package com.example.ignitepostgresmongo.service.impl;

import com.example.ignitepostgresmongo.config.IgniteConfig;
import com.example.ignitepostgresmongo.dto.UserDto;
import com.example.ignitepostgresmongo.entity.IgniteUser;
import com.example.ignitepostgresmongo.entity.PostgresUser;
import com.example.ignitepostgresmongo.repository.PostgresUserRepository;
import com.example.ignitepostgresmongo.service.IgniteUserService;
import com.example.ignitepostgresmongo.service.PostgresUserService;
import com.example.ignitepostgresmongo.utils.Converter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.ScanQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.hibernate.collection.internal.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
public class IgniteUserServiceImpl implements IgniteUserService {

    @Autowired
    PostgresUserRepository postgresUserRepository;

    @Autowired
    PostgresUserService postgresUserService;

    static AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext();

    static Ignite ignite;
    static IgniteCache<Long, UserDto> igniteCache;
    IgniteUserServiceImpl() {
        context.register(IgniteConfig.class);
        context.refresh();
        ignite = context.getBean(Ignite.class);

        CacheConfiguration<Long, UserDto> configuration = new CacheConfiguration<>();

        configuration.setCacheMode(CacheMode.PARTITIONED);
        configuration.setName("userCache");

        igniteCache = ignite.getOrCreateCache(configuration);
        log.info("cache size after creating  = " + igniteCache.metrics().getCacheSize());
    }

//    @Override
//    public IgniteUser addUser(IgniteUser igniteUser) {
//        igniteCache.put(igniteUser.getId(), igniteUser);
//        return igniteUser;
//    }

    public UserDto getUser(Long id){
        return igniteCache.get(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        QueryCursor<Cache.Entry<Long, UserDto>> queryCursor = igniteCache.query(new ScanQuery<>());
        return queryCursor.getAll().stream()
                .map(Cache.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNumberOfRecord() {
        return getAllUsers().size();
    }

    @Override
    public void addAll(List<UserDto> userDtoList) {
        HashMap<Long, UserDto> userDtoHashMap = new HashMap<>();
        Random random = new Random();
        long count = userDtoList.stream()
                                    .map(userDto -> userDtoHashMap.put(random.nextLong(), userDto))
                                    .count();

        igniteCache.putAll(userDtoHashMap);

//        Executors.newCachedThreadPool().execute(new Runnable() {
//            @Override
//            public void run() {
//                addToPostgresAndMongo(userDtoList);
//            }
//        });
    }

    public void addToPostgresAndMongo(List<UserDto> userDtoList){

        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Long> future = threadpool.submit(() -> {
            AtomicLong count = new AtomicLong();
            List<PostgresUser> postgresUsers = new ArrayList<>();

            igniteCache.forEach(longUserDtoEntry -> {
                postgresUsers.add(Converter.toPostgresUserEntity(igniteCache
                        .get(longUserDtoEntry.getKey())));
                count.getAndIncrement();
                postgresUserService.addAll(postgresUsers);
                System.out.println("Added 1 Lakh Users!");
                System.out.println(count.get());
            });
            return count.get();
        });
        try {
            if (future.isDone()) {
                System.out.println("Done!, inserted : " + future.get());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        Executors.newSingleThreadExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//
//                AtomicLong count = new AtomicLong();
//                List<PostgresUser> postgresUsers = new ArrayList<>();
//
//                igniteCache.forEach(longUserDtoEntry -> {
//                    postgresUsers.add(Converter.toPostgresUserEntity(igniteCache
//                            .get(longUserDtoEntry.getKey())));
//                    count.getAndIncrement();
//                    postgresUserService.addAll(postgresUsers);
//                    System.out.println("Added 1 Lakh Users!");
//                    System.out.println(count.get());
//                });
//                System.out.println("Done!, inserted : " + count.get());
//            }
//        });
    }

    @Override
    public String addManyIgniteUsers(Long count) {
        List<UserDto> userDtoList = new ArrayList<>();
        Random random = new Random();
        long start = System.currentTimeMillis();
        System.out.println("STARTED CREATING OBJECTS!");
        for(int i = 0; i < count; i++){
            UserDto userDto = new UserDto();
            userDto.setName("employee - " + Math.abs(random.nextLong()));
            userDto.setAge((20 + random.nextInt(40)));

            userDtoList.add(userDto);
            if(userDtoList.size() == 100000){
                addAll(userDtoList);
                userDtoList = new ArrayList<>();
            }
        }
        System.out.println("FINISHED ADDING OBJECTS TO IGNITE!");

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                addFromIgnite();
            }
        });
        long end = System.currentTimeMillis();
        return ((end - start)/1000) + "s --- " + ((end - start)/60000) + "min";
    }

    @Override
    public void deleteAllFromCache() {
        igniteCache.removeAll();
    }

    public void addFromIgnite(){
        final List<PostgresUser>[] postgresUsers = new List[]{new ArrayList<>()};
        System.out.println("GETTING OBJECTS FROM IGNITE AND CONVERTING THEM!");
        igniteCache.forEach(entry -> {
            PostgresUser postgresUser = Converter.toPostgresUserEntity(igniteCache.getAndRemove(entry.getKey()));
            postgresUsers[0].add(postgresUser);

            if(postgresUsers[0].size() == 100000){
                System.out.println("POSTGRES ADD ALL METHOD CALLED!");
                postgresUserService.addAll(postgresUsers[0]);
                postgresUsers[0] = new ArrayList<>();
            }
        });

    }
}
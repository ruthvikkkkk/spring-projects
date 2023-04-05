package com.myexamples.reactivetwo.reactivetwo.services.impl;

import com.myexamples.reactivetwo.reactivetwo.dto.DirectorDto;
import com.myexamples.reactivetwo.reactivetwo.entity.Director;
import com.myexamples.reactivetwo.reactivetwo.repository.DirectorRepository;
import com.myexamples.reactivetwo.reactivetwo.services.DirectorService;
import com.myexamples.reactivetwo.reactivetwo.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    DirectorRepository directorRepository;

    @Override
    public Mono<Director> addDirector(DirectorDto directorDto) {
        return directorRepository.findByName(directorDto.getName())
                .map(director -> {
//                    if(!director.getName().equals("")){
                        return director;
//                    }else{
//                        return directorRepository.save(DataUtils.dtoToEntity(directorDto));
//                        return Mono.just(director);
//                    }
                });
    }

    @Override
    public Flux<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Mono<Integer> getDirectorAgeByName(String name) {
        return directorRepository.findDirectorAgeByName(name);
    }

    @Override
    public Flux<Director> getDirectorsByAge(Integer age) {
        return directorRepository.findDirectorsByAge(age);
    }

    @Override
    public Mono<Director> checkIfDirectorExists(String name) {
        return directorRepository.findByName(name);
    }

    @Override
    public Mono<Integer> updateAgeByName(String name, Integer age) {
        return directorRepository.updateAgeByName(name, age);
    }

    @Override
    public Mono<Void> deleteByName(String name) {
        return directorRepository.deleteByName(name);
    }
}

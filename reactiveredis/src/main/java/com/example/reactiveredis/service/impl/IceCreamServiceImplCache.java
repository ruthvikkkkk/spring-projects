package com.example.reactiveredis.service.impl;

import com.example.reactiveredis.entity.IceCream;
import com.example.reactiveredis.service.IceCreamCacheService;
import com.example.reactiveredis.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@ConditionalOnProperty(name = "cache.enabled", havingValue = "true")
public class IceCreamServiceImplCache implements IceCreamCacheService {

    private final String KEY = "iceCreams";

    @Autowired
    ReactiveHashOperations<String, String, IceCream> reactiveHashOperations;

    @Override
    public Flux<IceCream> getAll() {
        return reactiveHashOperations.values(KEY);
    }

    @Override
    public Mono<IceCream> getDetailsByFlavor(String flavor) {
        return reactiveHashOperations.get(KEY, flavor);
    }

    @Override
    public Mono<Void> deleteIceCream(String flavor) {
        return reactiveHashOperations.remove(KEY, flavor).then();
    }

    @Override
    public Mono<Boolean> addOrUpdateIceCream(IceCream iceCream) {
        return reactiveHashOperations.put(KEY, iceCream.getFlavor(), iceCream);
    }
}
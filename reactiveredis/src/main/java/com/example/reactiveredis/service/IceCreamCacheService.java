package com.example.reactiveredis.service;

import com.example.reactiveredis.entity.IceCream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IceCreamCacheService {
    Flux<IceCream> getAll();
    Mono<IceCream> getDetailsByFlavor(String flavor);
    Mono<Void> deleteIceCream(String flavor);
    Mono<Boolean> addOrUpdateIceCream(IceCream iceCream);
}
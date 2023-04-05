package com.example.reactiveredis.service;

import com.example.reactiveredis.entity.IceCream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IceCreamService {
    Flux<IceCream> getAll();
    Mono<IceCream> getDetailsByFlavor(String flavor);
    Mono<Void> updateCost(String flavor, Double cost);
    Mono<Void> updateQuantity(String flavor, Integer quantity);
    Mono<Void> deleteIceCream(String flavor);
    Mono<IceCream> addIceCream(IceCream iceCream);
}

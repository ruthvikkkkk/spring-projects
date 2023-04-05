package com.example.reactiveredis.service.impl;

import com.example.reactiveredis.entity.IceCream;
import com.example.reactiveredis.repository.IceCreamRepository;
import com.example.reactiveredis.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@ConditionalOnProperty(name = "cache.enabled", havingValue = "false")
public class IceCreamServiceImplNoCache implements IceCreamService {

    @Autowired
    IceCreamRepository iceCreamRepository;

    @Override
    public Flux<IceCream> getAll() {
        return iceCreamRepository.findAll();
    }

    @Override
    public Mono<IceCream> getDetailsByFlavor(String flavor) {
        return iceCreamRepository.findById(flavor);
    }

    @Override
    public Mono<Void> updateCost(String flavor, Double cost) {
        return iceCreamRepository.findById(flavor)
                .map(iceCream -> {
                    iceCream.setCostPerGram(cost);
                    return iceCreamRepository.save(iceCream);
                }).then();
    }

    @Override
    public Mono<Void> updateQuantity(String flavor, Integer quantity) {
        return iceCreamRepository.findById(flavor)
                .map(iceCream -> {
                    iceCream.setQuantity(quantity);
                    return iceCreamRepository.save(iceCream);
                }).then();
    }

    @Override
    public Mono<Void> deleteIceCream(String flavor) {
        return iceCreamRepository.deleteById(flavor);
    }

    @Override
    public Mono<IceCream> addIceCream(IceCream iceCream) {
        return iceCreamRepository.addIceCream(iceCream.getFlavor(), iceCream.getCostPerGram(), iceCream.getQuantity());
    }
}

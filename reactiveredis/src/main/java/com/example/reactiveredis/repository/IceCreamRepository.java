package com.example.reactiveredis.repository;

import com.example.reactiveredis.entity.IceCream;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface IceCreamRepository extends ReactiveCrudRepository<IceCream, String> {

    @Query("insert into icecream values(:flavor, :cost_per_gram, :quantity)")
    Mono<IceCream> addIceCream(@Param("flavor") String flavor, @Param("cost_per_gram") Double costPerGram, @Param("quantity") Integer quantity);
}

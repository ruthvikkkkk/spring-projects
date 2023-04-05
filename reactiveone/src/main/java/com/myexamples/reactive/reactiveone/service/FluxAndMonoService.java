package com.myexamples.reactive.reactiveone.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FluxAndMonoService {

    public Flux<String> stringFlux(){
        List<String> numbers = new ArrayList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        //numbers.forEach(System.out::println);
        return Flux.fromIterable(numbers);
    }

    public Flux<Integer> integerFluxMap(){
        return Flux.fromIterable(Arrays.asList("1", "2", "3"))
                .map(s -> Integer.parseInt(s) + 2);
    }

    public Flux<Integer> integerFluxFilter(int number){
        return Flux.fromIterable(Arrays.asList(1, 3, 4, 6, 9, 0, -2))
                .filter(s -> s > number);
    }

    public Flux<Integer> integerFluxTransform(Integer number){

        Function<Flux<Integer>, Flux<Integer>> dataFilter = data -> data.filter(s -> s > number);
        return Flux.fromIterable(Arrays.asList(1, 3, 4, 6, 9, 0, -2))
                .transform(dataFilter);
    }

    public Flux<Integer> integerFluxTransformDefault(Integer number){

        Function<Flux<Integer>, Flux<Integer>> dataFilter = data -> data.filter(s -> s > number);
        return Flux.fromIterable(Arrays.asList(1, 3, 4, 6, 9, 0, -2))
                .transform(dataFilter)
                .defaultIfEmpty(1000);
    }

    public Flux<String> stringFluxFlatMap(){
        return Flux.fromIterable(Arrays.asList("one", "two", "three"))
                .flatMap(s -> Flux.fromArray(s.split("")));
    }

    public Flux<String> stringFluxFlatMapAsync(){
        return Flux.fromIterable(Arrays.asList("four", "five", "six"))
                .delayElements(Duration.ofMillis(new Random().nextInt(1000)))
                .flatMap(s -> Flux.fromArray(s.split("")));
    }

    public Mono<String> stringMono(){
        return Mono.just("four");
    }

    public Flux<String> stringMonoFlatMapMany(){
        return Mono.just("four")
                .flatMapMany(s -> Flux.just(s.split("")));
    }

    public Flux<Integer> integerMonoConcat(){
        Mono<Integer> numOne = Mono.just(2);
        Mono<Integer> numTwo = Mono.just(3);

        return Flux.concat(numOne, numTwo);
    }

    public Flux<Integer> integerFluxMergeWith(){
        Flux<Integer> fluxOne = Flux.just(1, 2, 3, 4)
                .delayElements(Duration.ofMillis(50));
        Flux<Integer> fluxTwo = Flux.just(5, 6, 7, 8)
                .delayElements(Duration.ofMillis(75));

        return fluxOne.mergeWith(fluxTwo).log();
    }

    public Mono<Integer> integerFluxZip(){
        Flux<Integer> fluxOne = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> fluxTwo = Flux.just(4, 3, 2, 1, 10);

        Flux<Integer> fluxThree = (Flux.zip(fluxOne, fluxTwo, (first, second) -> {
            return first * second;
        })
                .defaultIfEmpty(0));
        final int[] sum = {0};

        Function<Flux<Integer>, Mono<Integer>> sumOfFlux = data -> data.reduce(0, (total, element) -> total + element);
        return fluxThree.transform(sumOfFlux).next();
    }

//    public Mono<Integer> integerSumFlux(){
//        Flux<Integer> fluxOne = Flux.just(1, 2, 3, 4, 5);
//        final Integer[] sum = {0};
//
//        return fluxOne.doOnNext(s -> {
//            s += sum[0];
//            System.out.println(sum[0]);
//        }).last();
//
//
//       // return Mono.just(sum[0]);
//    }

    public Flux<Integer> integerFluxErrorReturn(){
        return Flux.just(1, 2, 10, 0, 5, 2)
                .map(s -> 10/s)
                .onErrorReturn(-1);
    }

    public Flux<Integer> integerFluxErrorContinue(){
        return Flux.just(1, 2, 10, 0, 5, 2)
                .map(s -> 10/s)
                .onErrorContinue((e, i) -> System.out.println(e.getLocalizedMessage() + "\n" + i));
    }

    public static void main(String[] args) {

        FluxAndMonoService fluxAndMonoService = new FluxAndMonoService();

        fluxAndMonoService.stringFlux().subscribe(s -> System.out.println("flux s = " + s));

        System.out.println();

        fluxAndMonoService.integerFluxMap().subscribe(s -> {
            System.out.println("map s = " + s);
        });

        System.out.println();

        fluxAndMonoService.stringMono().subscribe(s -> {
            System.out.println("mono s = " + s);
        });

        System.out.println();

        fluxAndMonoService.integerFluxFilter(3).subscribe(s -> System.out.println("filter s = " + s));

        System.out.println();

        fluxAndMonoService.stringFluxFlatMap().subscribe(s -> System.out.println("flatmap s = " + s));

        System.out.println();

        fluxAndMonoService.stringFluxFlatMapAsync().subscribe(s -> System.out.println("async flatmap s = " + s));

        System.out.println();

        fluxAndMonoService.stringMonoFlatMapMany().subscribe(s -> System.out.println("flatmap many s = " + s));

        System.out.println();

        fluxAndMonoService.integerFluxTransform(3).subscribe(s -> System.out.println("transform s = " + s));

        System.out.println();

        fluxAndMonoService.integerFluxTransformDefault(10).subscribe(s -> System.out.println("default s = " + s));

        System.out.println();

        fluxAndMonoService.integerMonoConcat().subscribe(s -> System.out.println("concat s = " + s));

        System.out.println();

        fluxAndMonoService.integerFluxMergeWith().subscribe(s -> System.out.println("merge with async s = " + s));

        System.out.println();

        fluxAndMonoService.integerFluxZip().subscribe(s -> System.out.println("zip s = " + s));

        System.out.println();

        fluxAndMonoService.integerFluxErrorReturn().subscribe(s -> System.out.println("error return s = " + s));

        System.out.println();

        fluxAndMonoService.integerFluxErrorContinue().subscribe(s -> System.out.println("error continue s = " + s));

//        fluxAndMonoService.integerSumFlux().subscribe(s -> System.out.println("sum flux s = " + s));
    }
}

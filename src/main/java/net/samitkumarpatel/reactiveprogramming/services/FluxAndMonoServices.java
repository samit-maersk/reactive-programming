package net.samitkumarpatel.reactiveprogramming.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class FluxAndMonoServices {
    public Mono<String> fruitsMono() {
        return Mono.just("Apple").log();
    }

    public Flux<String> fruitsFlux() {
        return Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry").log();
    }

    public Flux<String> fruitsFluxMap() {
        return fruitsFlux().map(String::toUpperCase);
        // OR

        //return Flux.fromIterable(List.of("Apple", "Orange", "Grape", "Banana", "Strawberry")).map(String::toUpperCase);
    }

    public Flux<String> fruitsFluxFilter(int length) {
        return fruitsFlux().filter(fruit -> fruit.length() > length);
    }

    public Flux<String> fruitsFluxFilterMap(int length) {
        return fruitsFlux()
                .filter(fruit -> fruit.length() > length)
                .map(String::toUpperCase);
    }

    public Flux<String> fruitsFluxFlatMap() {
        return fruitsFlux()
                .flatMap(fruit -> Flux.just(fruit.split("")));
        //Or
//        return Flux.fromIterable(List.of("Apple", "Orange", "Grape", "Banana", "Strawberry"))
//                .flatMap(fruit -> Flux.just(fruit.split("")))
//                .log();
    }

    public Mono<List<String>> fruitsMonoFlatMap() {
        return fruitsMono()
                .flatMap(fruit -> Mono.just(List.of(fruit.split(""))));
    }

    public Flux<String> fruitsFluxFlatMapAsync() {
        return fruitsFlux()
                .flatMap(fruit -> Flux.just(fruit.split("")));
    }

    //This will preserve the order
    public Flux<String> fruitsFluxConcatMap() {
        return fruitsFlux()
                .concatMap(fruit -> Flux.just(fruit.split("")))
                //.delayElements(Duration.ofMillis(1000))
                .log();
    }

    public Flux<String> fruitsMonoFlatMapMany() {
        return fruitsMono()
                .flatMapMany(fruit -> Flux.just(fruit.split("")))
                .log();
    }

    public Flux<String> fruitsFluxTransform(int length) {
        return fruitsFlux()
                .transform(fruitFlux -> fruitFlux.filter(fruit -> fruit.length() > length))
                .map(String::toUpperCase);
    }

    public Flux<String> fruitsFluxTransformDefaultIfEmpty(int length) {
        return fruitsFlux()
                .transform(fruitFlux -> fruitFlux.filter(fruit -> fruit.length() > length))
                .map(String::toUpperCase)
                .defaultIfEmpty("Default");
    }

    public Flux<String> fruitsFluxTransformSwitchIfEmpty(int length) {
        return fruitsFlux()
                .transform(fruitFlux -> fruitFlux.filter(fruit -> fruit.length() > length))
                .switchIfEmpty(Flux.just("Pineapple", "Watermelon"));
    }

    public Flux<String> fruitsFluxConcat() {
        return Flux.concat(fruitsFlux(), Flux.just("Pineapple", "Watermelon"));
    }

    public Flux<String> fruitsFluxConcatWith() {
        return fruitsFlux()
                .concatWith(Flux.just("Pineapple", "Watermelon"));
    }

    public Flux<String> fruitsMonoConcatWith() {
        return fruitsMono()
                .concatWith(Mono.just("Pineapple"));
    }

}

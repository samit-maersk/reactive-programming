package net.samitkumarpatel.reactiveprogramming;

import net.samitkumarpatel.reactiveprogramming.services.FluxAndMonoServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class FluxTest {
    FluxAndMonoServices fluxAndMonoServices;
    @BeforeEach
    void setUp() {
        fluxAndMonoServices = new FluxAndMonoServices();
    }

    @AfterEach
    void tearDown() {}

    @Test
    @DisplayName("consume flux")
    void fluxTest01() {
        fluxAndMonoServices.fruitsFlux().subscribe(System.out::println);
    }

    @Test
    @DisplayName("How to Test flux")
    void fluxTest02() {
        fluxAndMonoServices.fruitsFlux()
                .as(StepVerifier::create)
                .expectNext("Apple", "Orange", "Grape", "Banana", "Strawberry")
                .verifyComplete();
    }

    @Test
    @DisplayName("Flux map")
    void fluxTest03() {
        fluxAndMonoServices.fruitsFluxMap()
                .as(StepVerifier::create)
                .expectNext("APPLE", "ORANGE", "GRAPE", "BANANA", "STRAWBERRY")
                .verifyComplete();
    }

    @Test
    @DisplayName("Flux Filter")
    void fluxTest04() {
        fluxAndMonoServices.fruitsFluxFilter(5)
                .as(StepVerifier::create)
                .expectNext("Orange", "Banana", "Strawberry")
                .verifyComplete();
    }

    @Test
    @DisplayName("Flux Filter With Map")
    void fluxTest05() {
        fluxAndMonoServices.fruitsFluxFilterMap(5)
                .as(StepVerifier::create)
                .expectNext("ORANGE", "BANANA", "STRAWBERRY")
                .verifyComplete();
    }

    @Test
    @DisplayName("Flux flatMap")
    void fluxTest06() {
        fluxAndMonoServices.fruitsFluxFlatMap()
                .as(StepVerifier::create)
                .expectNext("A", "p", "p", "l", "e", "O", "r", "a", "n", "g", "e", "G", "r", "a", "p", "e", "B", "a", "n", "a", "n", "a", "S", "t", "r", "a", "w", "b", "e", "r", "r", "y")
                .verifyComplete();
    }

    @Test
    @DisplayName("Flux flatMap Async")
    @Disabled
    void fluxTest07() {
        fluxAndMonoServices.fruitsFluxFlatMapAsync()
                .as(StepVerifier::create)
                .expectNextCount(30)
                // The Order of the letters is not guaranteed, Hence Just counting it.
                //.expectNext("A", "p", "p", "l", "e", "O", "r", "a", "n", "g", "e", "G", "r", "a", "p", "e", "B", "a", "n", "a", "n", "a", "S", "t", "r", "a", "w", "b", "e", "r", "r", "y")
                .verifyComplete();

    }

    @Test
    @DisplayName("Flux concatMap")
    @Disabled
    void fluxTest08() {
        fluxAndMonoServices.fruitsFluxConcatMap()
                .as(StepVerifier::create)
                .expectNextCount(30)
                .verifyComplete();

    }

    @Test
    @DisplayName("Flux transform")
    void fluxTest09() {
        fluxAndMonoServices.fruitsFluxTransform(5)
                .as(StepVerifier::create)
                .expectNext("ORANGE", "BANANA", "STRAWBERRY")
                .verifyComplete();

    }

    @Test
    @DisplayName("Flux defaultIfEmpty")
    void fluxTest10() {
        fluxAndMonoServices.fruitsFluxTransformDefaultIfEmpty(10)
                .as(StepVerifier::create)
                .expectNext("Default")
                .verifyComplete();

    }

    @Test
    @DisplayName("Flux switchIfEmpty")
    void fluxTest11() {
        fluxAndMonoServices.fruitsFluxTransformSwitchIfEmpty(10)
                .as(StepVerifier::create)
                .expectNext("Pineapple", "Watermelon")
                .verifyComplete();

    }

    @Test
    @DisplayName("Flux concat")
    void fluxTest12() {
        fluxAndMonoServices.fruitsFluxConcat()
                .as(StepVerifier::create)
                .expectNext("Apple", "Orange", "Grape", "Banana", "Strawberry", "Pineapple", "Watermelon")
                .verifyComplete();

    }

    @Test
    @DisplayName("Flux concatWith")
    void fluxTest13() {
        fluxAndMonoServices.fruitsFluxConcatWith()
                .as(StepVerifier::create)
                .expectNext("Apple", "Orange", "Grape", "Banana", "Strawberry", "Pineapple", "Watermelon")
                .verifyComplete();

    }



}

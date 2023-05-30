package net.samitkumarpatel.reactiveprogramming;

import net.samitkumarpatel.reactiveprogramming.services.FluxAndMonoServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class MonoTest {
    FluxAndMonoServices fluxAndMonoServices;
    @BeforeEach
    void setUp() {
        fluxAndMonoServices = new FluxAndMonoServices();
    }

    @AfterEach
    void tearDown() {}

    @Test
    @DisplayName("consume mono & print")
    void monoTest01() {
        fluxAndMonoServices.fruitsMono().subscribe(System.out::println);
    }

    @Test
    @DisplayName("How to test mono")
    void monoTest02() {
        fluxAndMonoServices
                .fruitsMono()
                .as(StepVerifier::create)
                .expectNext("Apple")
                .verifyComplete();
    }

    @Test
    @DisplayName("mono flatmap")
    void monoTest03() {
        fluxAndMonoServices
                .fruitsMonoFlatMap()
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("mono flatMapMany")
    void monoTest04() {
        fluxAndMonoServices
                .fruitsMonoFlatMapMany()
                .as(StepVerifier::create)
                .expectNext("A","p","p","l","e")
                .verifyComplete();
    }

    @Test
    @DisplayName("mono concatWith")
    void monoTest05() {
        fluxAndMonoServices
                .fruitsMonoConcatWith()
                .as(StepVerifier::create)
                .expectNext("Apple","Pineapple")
                .verifyComplete();
    }


}

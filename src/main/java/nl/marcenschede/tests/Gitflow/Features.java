package nl.marcenschede.tests.Gitflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class Features {

    @GetMapping("/feature1")
    public Mono<String> feature1() {
        return Mono.just("Hello World!");
    }

    @GetMapping("/feature2")
    public Mono<String> feature2() {
        return Mono.just("Hello World!");
    }

    @GetMapping(value = "/feature3", produces = "application/stream+json")
    public Flux<Container> feature3() {
        return Flux
                .just("Hello Feature3", "Hello Feature3a", "Hello Feature3b", "Hello Feature3c")
                .map(Container::new)
                .delayElements(Duration.ofSeconds(1))
                .map( x -> {
                    System.out.println(x.text);
                    return x;
                });
    }

    public static class Container {
        public String text;

        public Container() {
        }

        public Container(String text) {
            this.text = text;
        }
    }
}

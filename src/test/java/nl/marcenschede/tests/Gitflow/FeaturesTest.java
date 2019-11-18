package nl.marcenschede.tests.Gitflow;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;

class FeaturesTest {

    private static final Logger logger = LoggerFactory.getLogger(FeaturesTest.class);

    @Test
    void feature3() throws InterruptedException {
        final WebClient producerClient = WebClient.create("http://localhost:8080/feature3");

        Flux<Features.Container> entries = producerClient.get()
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(Features.Container.class))
                .doOnComplete(() -> logger.info("That's it"));

        entries.subscribe(n -> logger.info("Value: {}", n.text));


        Thread.sleep(6500L);
    }
}
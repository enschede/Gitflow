package nl.marcenschede.tests.Gitflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class GitflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitflowApplication.class, args);
	}

	@GetMapping("/feature1")
	public Mono<String> feature1() {
		return Mono.just("Hello World!");
	}

	@GetMapping("/feature2")
	public Mono<String> feature2() {
		return Mono.just("Hello World!");
	}

	@GetMapping("/feature3")
	public Mono<String> feature3() {
		return Mono.just("Hello World!");
	}
}

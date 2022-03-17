package by.zhigalko.restclient.reactive;

import by.zhigalko.restclient.dto.Greeting;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ReactiveRestClient {
    public Mono<Greeting> getGreetingNonBlocking() throws InterruptedException {
        Mono<Greeting> greetingMono = WebClient.create()
                .get()
                .uri("http://localhost:8081/greeting")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Greeting.class);
        System.out.println("start");
        for (int i = 1; i < 10; i++) {
            System.out.println(i + 1);
        }
        greetingMono.subscribe(greeting -> System.out.println(greeting.toString()));
        Thread.sleep(3000L);
        System.out.println("end");
        return greetingMono;
    }
}

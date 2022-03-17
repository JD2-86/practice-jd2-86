package by.zhigalko.restclient;

import by.zhigalko.restclient.blocking.BlockingRestClient;
import by.zhigalko.restclient.dto.Greeting;
import by.zhigalko.restclient.reactive.ReactiveRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class GreetingController {
    private final BlockingRestClient blockingRestClient;
    private final ReactiveRestClient reactiveRestClient;

    @Autowired
    public GreetingController(BlockingRestClient blockingRestClient, ReactiveRestClient reactiveRestClient) {
        this.blockingRestClient = blockingRestClient;
        this.reactiveRestClient = reactiveRestClient;
    }

    @GetMapping("/greeting")
    public String getGreeting(Model model) {
        Greeting greeting = blockingRestClient.getGreetingBlocking();
        model.addAttribute("greeting", greeting.toString());
        return "greeting";
    }

    @GetMapping("/greeting/reactive")
    public String getGreetingReactive(Model model) {
        Mono<Greeting> greeting = null;
        try {
            greeting = reactiveRestClient.getGreetingNonBlocking();
        } catch (InterruptedException e) {
            return "error";
        }
        model.addAttribute("greeting", greeting.share().block());
        return "greeting";
    }
}

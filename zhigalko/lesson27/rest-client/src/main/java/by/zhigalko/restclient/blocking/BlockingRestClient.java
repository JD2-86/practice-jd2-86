package by.zhigalko.restclient.blocking;

import by.zhigalko.restclient.dto.Greeting;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BlockingRestClient {
    public Greeting getGreetingBlocking() {
        final String uri = "http://localhost:8081/greeting";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Greeting> response = restTemplate.exchange(
                uri, HttpMethod.GET, null, Greeting.class);
        return response.getBody();
    }
}

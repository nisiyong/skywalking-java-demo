package io.github.nisiyong.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;

/**
 * @author nisiyong
 */
@RestController
@SpringBootApplication
public class ConsumerApplication {

    private static final String PROVIDER_URL = "http://localhost:8090/world";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(String name) {
        String uriString = UriComponentsBuilder.fromHttpUrl(PROVIDER_URL)
                .queryParam("name", name)
                .toUriString();

        String response = restTemplate.getForObject(uriString, String.class);
        return "hello " + response;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}

package io.github.nisiyong.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nisiyong
 */
@RestController
@SpringBootApplication
public class ProviderApplication {

    @RequestMapping("/world")
    public String world(String name) {
        return "world, " + name;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}

package com.basic;

import com.basic.spring.objectmapper.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


@RestController
@Slf4j
public class MyRestController {

    private final RestTemplate restTemplate;

    public MyRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/objectMapper")
    public Item getItem() {
        Item item = new Item();
        item.setId("a1");
        item.setName("hello");
        item.setLocalDateTime(LocalDate.now());
        return item;
    }

    @GetMapping("/target")
    public String target() {
        log.info("target");
        return "target";
    }

    @GetMapping("/restTemplate")
    public String restTemplate() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/target", String.class);
        String body = forEntity.getBody();
        log.info("body: {}", body);
        return "restTemplate";
    }
}

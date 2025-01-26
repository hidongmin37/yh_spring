package com.basic;

import com.basic.spring.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@Slf4j
public class MyRestController {

    @GetMapping("/objectMapper")
    public Item getItem() {
        Item item = new Item();
        item.setId("a1");
        item.setName("hello");
        item.setLocalDateTime(LocalDate.now());
        return item;
    }
}

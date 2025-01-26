package com.basic.spring;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Item {

    private String id;
    private String name;
    private LocalDate localDateTime;
}

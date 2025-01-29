package com.basic.spring.objectmapper;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Item {

    private String id;
    private String name;
    private LocalDate localDateTime;
}

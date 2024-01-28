package jpabasic.hellojpa;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("책")
public class Book extends Item{

    private String author;
    private String isbn;
}

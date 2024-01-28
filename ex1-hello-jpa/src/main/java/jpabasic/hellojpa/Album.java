package jpabasic.hellojpa;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("앨범")
public class Album extends Item{

    private String artist;

}

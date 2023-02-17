package com.dkrucze.Restaurantor.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.LinkedList;

@Data
@Document("restaurants")
public class Restaurant {
    @Id
    @Indexed
    @Field(name = "_id")
    private String object_id;
    @Indexed(unique = true)
    private String restaurant_id;
    private String name;
    private String cuisine;
    private String borough;
    private Address address;
    private LinkedList<Grade> grades;

    //Constructor for test Restaurant instances
    public Restaurant(String name) {
        this.name = name;
    }
}

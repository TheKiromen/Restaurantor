package com.dkrucze.Restaurantor.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;

@Data
@Document("restaurants")
public class Restaurant {
    @Id
    @Indexed
    private String id;
    private String name;
    private String cuisine;
    private String borough;
    private Address address;
    private LinkedList<Grade> grades;
    //Not used at the moment, good for querying for specific Restaurant?
    //@Indexed
    //private String restaurant_id;

    //Constructor for test Restaurant instances
    public Restaurant(String name) {
        this.name = name;
    }
}

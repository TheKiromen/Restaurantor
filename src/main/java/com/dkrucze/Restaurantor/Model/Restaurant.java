package com.dkrucze.Restaurantor.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("restaurants")
public class Restaurant {
    @Id
    @Indexed
    private String id;
    private String name;
    private String cuisine;
    private String borough;
    //TODO Custom address object?
    private Object address;
    //TODO Custom grade object?
    private Object[] grades;

    public Restaurant(String name) {
        this.name = name;
    }
}

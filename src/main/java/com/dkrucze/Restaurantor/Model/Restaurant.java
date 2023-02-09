package com.dkrucze.Restaurantor.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("Test")
public class Restaurant {
    @Id
    private String id;
    @Field(name="name")
    private String name;
}

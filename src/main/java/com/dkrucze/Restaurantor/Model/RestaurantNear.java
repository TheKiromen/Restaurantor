package com.dkrucze.Restaurantor.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class RestaurantNear {

    @Indexed(unique = true)
    private String restaurant_id;
    private String name;
    private String cuisine;
    private Address address;
    private double distance;

}

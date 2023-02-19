package com.dkrucze.Restaurantor.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Address {

    private String building;
    private String street;
    private String zipcode;
    //Sample data coordinates point to abstract places around the world, like Antarctica or oceans.
    //Uses geospatial 2dSphere index type for calculating distances.
    @Indexed
    @Field(name = "coord")
    private double[] coordinates;

}

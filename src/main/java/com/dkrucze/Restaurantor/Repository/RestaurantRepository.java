package com.dkrucze.Restaurantor.Repository;

import com.dkrucze.Restaurantor.Model.Restaurant;
import com.dkrucze.Restaurantor.Model.RestaurantNear;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

    //Same result as query below
    //@Query(value = "{'name':?0}")
    List<Restaurant> findByName(String name);

    //Basically just findAll but pageable
    @Query(value = "{}")
    Page<Restaurant> findAllRestaurants(Pageable pageable);

    //Find specific instance of Restaurant
    @Query(value = "{'restaurant_id' : ?0}")
    Restaurant findByRestaurant_id(String restaurant_id);

    //Find all restaurants that are no further than maxDistance.
    //Distance is represented as meters, location uses geographical coordinates.
    @Aggregation(pipeline = {
            "{$geoNear:{" +
                    "near:{" +
                        "type: 'Point'," +
                        "'coordinates': [?0, ?1]" +
                        "}," +
                    "distanceField:'distance'," +
                    "maxDistance:?2," +
                    "spherical:true" +
                "}" +
            "}",
            "{$sort: {'distance':1}}"
    })
    List<RestaurantNear> findNearestRestaurants(double latitude, double longitude, int maxDistance, Pageable pageable);

}

package com.dkrucze.Restaurantor.Repository;

import com.dkrucze.Restaurantor.Model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

    // Same result as query below
    // @Query(value = "{'name':?0}")
    List<Restaurant> findByName(String name);

    //Basically just findAll but pageable
    @Query(value = "{}")
    Page<Restaurant> findAllRestaurants(Pageable pageable);

}

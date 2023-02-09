package com.dkrucze.Restaurantor.Repository;

import com.dkrucze.Restaurantor.Model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
}

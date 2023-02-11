package com.dkrucze.Restaurantor.Service.Signature;

import com.dkrucze.Restaurantor.Model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {

    List<Restaurant> getRestaurantByName(String name);

    List<Restaurant> getAllRestaurants(int page);
}

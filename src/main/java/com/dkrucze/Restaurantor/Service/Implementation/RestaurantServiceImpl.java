package com.dkrucze.Restaurantor.Service.Implementation;

import com.dkrucze.Restaurantor.Model.Restaurant;
import com.dkrucze.Restaurantor.Repository.RestaurantRepository;
import com.dkrucze.Restaurantor.Service.Signature.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}

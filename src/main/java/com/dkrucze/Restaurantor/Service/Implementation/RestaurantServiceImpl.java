package com.dkrucze.Restaurantor.Service.Implementation;

import com.dkrucze.Restaurantor.Model.Restaurant;
import com.dkrucze.Restaurantor.Repository.RestaurantRepository;
import com.dkrucze.Restaurantor.Service.Signature.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants(int page) {
        return restaurantRepository.findAllRestaurants(PageRequest.of(page,20)).get().toList();
    }

    @Override
    public List<Restaurant> getRestaurantsByName(String name) {
        return restaurantRepository.findByName(name);
    }

    @Override
    public Restaurant getRestaurantByID(String id) {
        return restaurantRepository.findByRestaurant_id(id);
    }


}

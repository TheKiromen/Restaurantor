package com.dkrucze.Restaurantor.Controller;

import com.dkrucze.Restaurantor.Model.Restaurant;
import com.dkrucze.Restaurantor.Service.Implementation.RestaurantServiceImpl;
import com.dkrucze.Restaurantor.Service.Signature.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantServiceImpl rsi) {
        restaurantService = rsi;
    }

    @GetMapping("/")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }
}

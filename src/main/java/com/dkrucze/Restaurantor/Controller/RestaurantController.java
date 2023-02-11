package com.dkrucze.Restaurantor.Controller;

import com.dkrucze.Restaurantor.Model.Restaurant;
import com.dkrucze.Restaurantor.Service.Implementation.RestaurantServiceImpl;
import com.dkrucze.Restaurantor.Service.Signature.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantServiceImpl rsi) {
        restaurantService = rsi;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Restaurant>> getRestaurantByName(@PathVariable String name){
        return ResponseEntity.ok(restaurantService.getRestaurantByName(name));
    }

    @GetMapping("/")
    public ResponseEntity<List<Restaurant>> getRestaurantByName(@RequestParam int page){
        return ResponseEntity.ok(restaurantService.getAllRestaurants(page));
    }
}

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

    //Return 20 most recent restaurants by default
    @GetMapping("/")
    public ResponseEntity<List<Restaurant>> getDefaultEndpoint(){
        return getAllRestaurants(0);
    }

    //Browse all the existing restaurants
    @GetMapping(value = "/", params = "page")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestParam(defaultValue = "0") int page){
        return ResponseEntity.ok(restaurantService.getAllRestaurants(page));
    }

    //Query for a specific restaurant
    @GetMapping(value = "/", params = "id")
    public ResponseEntity<Restaurant> getRestaurantByID(@RequestParam(defaultValue = "") String id){
        return ResponseEntity.ok(restaurantService.getRestaurantByID(id));
    }

    //Find all restaurants matching given name
    @GetMapping("/{name}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByName(@PathVariable String name){
        return ResponseEntity.ok(restaurantService.getRestaurantsByName(name));
    }


}

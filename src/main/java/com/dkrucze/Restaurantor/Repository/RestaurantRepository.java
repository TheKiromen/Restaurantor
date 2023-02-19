package com.dkrucze.Restaurantor.Repository;

import com.dkrucze.Restaurantor.Model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

//TMP Query Finds all restaurants near specified point matching set distance
// db.restaurants.find({
//   'address.coord':{
//     $near:{
//       $geometry: {type: "Point", coordinates: [-73.9667, 40.78]},
//       $minDistance: 0,
//       $maxDistance: 1000
//     }
//   }
// })

//TMP Query Finds all distances from given point
// TODO Add sorting by distance, maxDistance as parameter, results paginated
// db.restaurants.aggregate([{
//   $geoNear: {
//     near: { type: "Point", coordinates: [ -73.99279 , 40.719296 ] },
//     distanceField: "distance",
//     spherical: true
//   }
// }])


}

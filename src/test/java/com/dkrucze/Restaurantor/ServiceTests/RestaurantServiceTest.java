package com.dkrucze.Restaurantor.ServiceTests;

import com.dkrucze.Restaurantor.Model.Restaurant;
import com.dkrucze.Restaurantor.Repository.RestaurantRepository;
import com.dkrucze.Restaurantor.Service.Implementation.RestaurantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.LinkedList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantServiceImpl restaurantService;

    @Test
    void Returns_SinglePage_Result() {
        //Given
        List<Restaurant> expected = new LinkedList<>();
        for(int i=1;i<=20;i++){
            expected.add(new Restaurant("Restaurant "+i));
        }
        Page<Restaurant> returned = new PageImpl<>(expected);
        BDDMockito.given(restaurantRepository.findAllRestaurants(ArgumentMatchers.any(PageRequest.class))).willReturn(returned);

        //When
        List<Restaurant> actual = restaurantService.getAllRestaurants(0);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Returns_Matching_Restaurants() {
        //Given
        List<Restaurant> expected = new LinkedList<>();
        expected.add(new Restaurant("Restaurant 1"));
        expected.add(new Restaurant("Restaurant 1"));
        BDDMockito.given(restaurantRepository.findByName("Restaurant 1")).willReturn(new LinkedList<>(expected));

        //When
        List<Restaurant> actual = restaurantService.getRestaurantsByName("Restaurant 1");

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Returns_Empty_List(){
        //Given
        List<Restaurant> expected = new LinkedList<>();
        BDDMockito.given(restaurantRepository.findByName("NonExistingName")).willReturn(new LinkedList<>());

        //When
        List<Restaurant> actual = restaurantService.getRestaurantsByName("NonExistingName");

        //Then
        Assertions.assertEquals(expected, actual);
    }
}
package com.dkrucze.Restaurantor.ControllerTests;

import com.dkrucze.Restaurantor.Controller.RestaurantController;
import com.dkrucze.Restaurantor.Model.Restaurant;
import com.dkrucze.Restaurantor.Service.Implementation.RestaurantServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureJsonTesters
@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    private MockMvc mvc;
    private JacksonTester<List<Restaurant>> jsonRestaurant;
    private static List<Restaurant> data;

    @Autowired
    public RestaurantControllerTest(MockMvc mvc, JacksonTester<List<Restaurant>> jsonRestaurant) {
        this.mvc = mvc;
        this.jsonRestaurant = jsonRestaurant;
    }

    @MockBean
    private RestaurantServiceImpl restaurantService;

    @BeforeAll
    public static void initializeData(){
        data = new LinkedList<>();
        for(int i=1; i<=30; i++){
            data.add(new Restaurant("Restaurant "+i));
        }
    }


    @Test
    void Returns_10_Restaurants() throws Exception {
        //Given
        List<Restaurant> expected = data.subList(0,11);
        //Copy expected value to avoid list modification
        BDDMockito.given(restaurantService.getAllRestaurants(0)).willReturn(new LinkedList<>(expected));

        //When
        MockHttpServletResponse response = mvc.perform(get("/api/restaurants/?page=0")).andReturn().getResponse();

        //Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonRestaurant.write(expected).getJson());
    }

    @Test
    @Disabled
    void Returns_FirstOfTwoPages_Restaurants() throws Exception {

    }

    @Test
    @Disabled
    void Returns_Empty_List() throws Exception {

    }

    @Test
    @Disabled
    void Returns_Second_Page() throws Exception {

    }

    @Test
    @Disabled
    void Returns_DefaultFirst_Page() throws Exception {

    }


    @Test
    @Disabled
    void Returns_Single_Matching_Restaurant() throws Exception {

    }

    @Test
    void Returns_All_Matching_Restaurants() throws Exception {
        //Given
        List<Restaurant> expected = new LinkedList<>();
        expected.add(new Restaurant("Restaurant 5"));
        expected.add(new Restaurant("Restaurant 5"));
        //Copy expected value to avoid list modification
        BDDMockito.given(restaurantService.getRestaurantByName("Restaurant 5")).willReturn(new LinkedList<>(expected));

        //When
        MockHttpServletResponse response = mvc.perform(get("/api/restaurants/Restaurant 5")).andReturn().getResponse();

        //Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonRestaurant.write(expected).getJson());
    }
    
}
package com.dkrucze.Restaurantor.ControllerTests;

import com.dkrucze.Restaurantor.Controller.RestaurantController;
import com.dkrucze.Restaurantor.Model.Restaurant;
import com.dkrucze.Restaurantor.Service.Implementation.RestaurantServiceImpl;
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

    @Autowired
    public RestaurantControllerTest(MockMvc mvc, JacksonTester<List<Restaurant>> jsonRestaurant) {
        this.mvc = mvc;
        this.jsonRestaurant = jsonRestaurant;
    }

    @MockBean
    private RestaurantServiceImpl restaurantService;

    @Test
    void Returns_First_Page() throws Exception {
        //Given
        List<Restaurant> expected = new LinkedList<>();
        for(int i=1; i<=10; i++){
            expected.add(new Restaurant("Restaurant "+i));
        }
        //Copy expected value to avoid list modification
        BDDMockito.given(restaurantService.getAllRestaurants(0)).willReturn(new LinkedList<>(expected));

        //When
        MockHttpServletResponse actual = mvc.perform(get("/api/restaurants/")).andReturn().getResponse();

        //Then
        assertThat(actual.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(actual.getContentAsString()).isEqualTo(jsonRestaurant.write(expected).getJson());
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
        MockHttpServletResponse actual = mvc.perform(get("/api/restaurants/Restaurant 5")).andReturn().getResponse();

        //Then
        assertThat(actual.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(actual.getContentAsString()).isEqualTo(jsonRestaurant.write(expected).getJson());
    }

    @Test
    void Returns_BadRequest() throws Exception{
        //Given & When
        MockHttpServletResponse actual = mvc.perform(get("/api/restaurants/?page=abc")).andReturn().getResponse();

        //Then
        assertThat(actual.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
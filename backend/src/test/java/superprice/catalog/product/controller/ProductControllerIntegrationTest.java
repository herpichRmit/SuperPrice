package superprice.catalog.product.controller;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import superprice.catalog.Application;
import superprice.catalog.user.model.Customer;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.isNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    
    /* 
    @Autowired
    MockMvc mvc;

    @Autowired
    Flyway flyway;

    @BeforeEach
    private void setUp(){
        flyway.migrate();
    }

    //get product
    @Test
    void getProduct() throws Exception {
        mvc.perform(get("/api/v1/product").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[1].title", is("Spray and Wipe")));
    }

    //get id
    @Test
    void getId_2() throws Exception{
        mvc.perform(get("/api/v1/product/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.title", is("Spray and Wipe")));
    }

    //get title
    @Test
    void getTitle() throws Exception{
        mvc.perform(get("/api/v1/product/compare/Spray and Wipe").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[1].title", is("Spray and Wipe")));
    }

    //get productsbykeyword
    @Test
    void getByKeyword() throws Exception{
        mvc.perform(get("/api/v1/product/search/Spray and Wipe").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[1].title", is("Spray and Wipe")));
    }


    //get by category
    @Test
    void getByCategory() throws Exception{
        mvc.perform(get("/api/v1/product/category/Dairy").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.length()", is(5)));
    }


    //get by price
    @Test
    void getByPrice() throws Exception{
        mvc.perform(get("/api/v1/product/price/Spray and Wipe").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.length()", is(3)));
    }


    //AsjsonString
    public static String asJsonString(final Object obj) {
        try {
          return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
    }
    */
}

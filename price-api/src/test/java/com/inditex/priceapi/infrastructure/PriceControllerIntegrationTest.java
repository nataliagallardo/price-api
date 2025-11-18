package com.inditex.priceapi.infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  private static final String BASE_URL = "/prices";

  //TEST 1
  @Test
  void test1_price() throws Exception {
    mockMvc.perform(get(BASE_URL)
            .param("brandId", "1")
            .param("productId", "35455")
            .param("applicationDate", "2020-06-14 10:00:00")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.priceList").value(1))
        .andExpect(jsonPath("$.price").value(35.50));
  }

  //TEST 2
  @Test
  void test2_price() throws Exception {
    mockMvc.perform(get(BASE_URL)
            .param("brandId", "1")
            .param("productId", "35455")
            .param("applicationDate", "2020-06-14 16:00:00")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.priceList").value(2))
        .andExpect(jsonPath("$.price").value(25.45));
  }

  //TEST 3
  @Test
  void test3_price() throws Exception {
    mockMvc.perform(get(BASE_URL)
            .param("brandId", "1")
            .param("productId", "35455")
            .param("applicationDate", "2020-06-14 21:00:00")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.priceList").value(1))
        .andExpect(jsonPath("$.price").value(35.50));
  }

  //TEST 4
  @Test
  void test4_price() throws Exception {
    mockMvc.perform(get(BASE_URL)
            .param("brandId", "1")
            .param("productId", "35455")
            .param("applicationDate", "2020-06-15 10:00:00")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.priceList").value(3))
        .andExpect(jsonPath("$.price").value(30.50));
  }

  //TEST 5
  @Test
  void test5_price() throws Exception {
    mockMvc.perform(get(BASE_URL)
            .param("brandId", "1")
            .param("productId", "35455")
            .param("applicationDate", "2020-06-16 21:00:00")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.priceList").value(4))
        .andExpect(jsonPath("$.price").value(38.95));
  }
}

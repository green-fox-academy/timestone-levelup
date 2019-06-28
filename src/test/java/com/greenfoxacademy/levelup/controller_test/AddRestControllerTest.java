package com.greenfoxacademy.levelup.controller_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest
public class AddRestControllerTest {


  @Autowired
  MockMvc mockMvc;


  @Test
  public void whenAuthorizationIsOkAndHasNoMissingField_thenReturnsStatusCode201() throws Exception {
    String requestContent = "{\n" +
        "  \"version\": \"2.3\",\n" +
        "  \"name\": \"Badge inserter\",\n" +
        "  \"tag\": \"general\",\n" +
        "  \"levels\": [1, 2, 3, 4]\n" +
        "}".replaceAll("\\s", "");


    mockMvc.perform(post("/api/admin/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header("Authorization", "filled"))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  @Test
  public void whenAuthorizationIsMissingAndHasNoMissingField_thenReturnsStatusCode401() throws Exception{
    String requestContent = "{\n" +
        "  \"version\": \"2.3\",\n" +
        "  \"name\": \"Badge inserter\",\n" +
        "  \"tag\": \"general\",\n" +
        "  \"levels\": [1, 2, 3, 4]\n" +
        "}".replaceAll("\\s", "");

    mockMvc.perform(post("/api/admin/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header("Authorization", ""))
        .andDo(print())
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void whenMissingField_thenReturnsStatusCode404() throws Exception {
    String requestContent = "{\n" +
        "  \"version\": \"2.3\",\n" +
        "  \"name\": \"Badge inserter\",\n" +
        "  \"levels\": [1, 2, 3, 4]\n" +
        "}".replaceAll("\\s", "");

    mockMvc.perform(post("/api/admin/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header("Authorization", "filled"))
        .andDo(print())
        .andExpect(status().isNotFound());
  }
}
package com.greenfoxacademy.levelup.controller_test;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.controller.AddRestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AddRestController.class)
public class AddRestControllerTest {
  

  @Autowired
  MockMvc mockMvc;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void whenAuthorizationIsOk_thenReturnsStatusCode201() throws Exception {
    mockMvc.perform(post("/api/admin/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"version\": \"2.3\",\n" +
            "  \"name\": \"Badge inserter\",\n" +
            "  \"tag\": \"general\",\n" +
            "  \"levels\": \"[]\"\n" +
            "}"))
        .andExpect(status().isCreated());
  }






}

package com.greenfoxacademy.levelup.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.controller.IPItchesRestController;
import com.greenfoxacademy.levelup.controller.PitchesRestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class PitchesRestControllerTest {

  @Autowired
  PitchesRestController pitchesRestController;

  @Autowired
  MockMvc mockMvc;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void whenAuthorizationIsOk_thenReturnPitchesApiBody() throws Exception{
    pitchesRestController.setAuthorized(true);

    mockMvc.perform(get("/api/pitches")
      .contentType(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string(IPItchesRestController.BODY));
  }
}

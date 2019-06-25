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

  // @Mock
  PitchesRestController pitchesRestController;

  @Autowired
  MockMvc mockMvc;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void whenAuthorizationIsOk_thenReturnPitchesApiBody() throws Exception{

    mockMvc.perform(get("/api/pitches")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().string(IPItchesRestController.BODY));
  }



  @Test
  public void whenResponseStatusIsUnauthorized_thenReturnErrorBody() throws Exception {
    pitchesRestController.setAuthorized(false);

    mockMvc.perform(get("/api/pitches")
      .contentType(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(content().string(IPItchesRestController.ERROR_BODY));
  }

}

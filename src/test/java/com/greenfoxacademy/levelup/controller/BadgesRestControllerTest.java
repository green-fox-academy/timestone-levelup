package com.greenfoxacademy.levelup.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.service.IBadgeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BadgesRestController.class, secure = false)
public class BadgesRestControllerTest {

  @MockBean
  IBadgeService badgeService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void isAuthorized() throws Exception {

    mockMvc.perform(get("/api/badges")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(status().isOk())
        .andExpect(content().string(""))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void statusIsUnauthorized() throws Exception {
    mockMvc.perform(get("/api/badges")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(status().isUnauthorized())
        .andExpect(content().string(Message.UNAUTHORIZED_BODY))
        .andDo(print())
        .andReturn();
  }
}

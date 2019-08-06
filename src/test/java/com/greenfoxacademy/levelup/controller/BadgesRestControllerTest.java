package com.greenfoxacademy.levelup.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.repository.IBadgeRepository;
import com.greenfoxacademy.levelup.service.BadgeServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BadgesRestController.class, secure = false)
public class BadgesRestControllerTest {

  private Badge badge;

  private List<Badge> badgeList;

  @Autowired
  private MockMvc mockMvc;

  @InjectMocks
  private BadgeServiceImp badgeService;

  @MockBean
  private IBadgeRepository badgeRepository;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    badge = new Badge("2.3", "Process improver/initator", "general");
    badgeList = new ArrayList<>();
    badgeList.add(badge);
  }

  @Test
  public void testIfAuthorizationOK_thenReturnsStatusOk() throws Exception {
    mockMvc.perform(get("/api/badges")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(status().isOk())
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testIfAuthorizationOK_thenReturnsBadgesJsonObjects() throws Exception {
    when(badgeRepository.findAll()).thenReturn(badgeList);

    mockMvc.perform(get("/api/badges")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(content().string(new Gson().toJson(badge) + "\n"))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testWhenStatusIsUnauthorized_thenReturnsStatusUnauthorized() throws Exception {
    mockMvc.perform(get("/api/badges")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(status().isUnauthorized())
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testWhenStatusIsUnauthorized_thenReturnsUnauthorizedErrorBody() throws Exception {
    mockMvc.perform(get("/api/badges")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(content().string(Message.UNAUTHORIZED_BODY))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testIfPostAuthorizationOK_thenReturnsStatusCreated() throws Exception {
    String requestContent = Message.BADGE_FULL_BODY;
    mockMvc.perform(post("/api/badges")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  @Test
  public void testWhenPostStatusIsUnauthorized_thenReturnsStatusUnauthorized() throws Exception {
    String requestContent = Message.BADGE_FULL_BODY;
    mockMvc.perform(post("/api/badges")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(status().isUnauthorized())
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testWhenPostStatusIsUnauthorized_thenReturnsUnauthorizedErrorBody() throws Exception {
    String requestContent = Message.BADGE_FULL_BODY;
    mockMvc.perform(post("/api/badges")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(content().string(Message.UNAUTHORIZED_BODY))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void tesIfPostStatusIsAuthorized_thenSaveSuccessfully() {
    when(badgeRepository.save(any(Badge.class))).thenReturn(badge);
    badgeService.save(badge);

    assertEquals("general", badge.getTag());
    verify(badgeRepository, times(1)).save(badge);
  }

  @TestConfiguration
  static class BadgeServiceImpTestContextConfiguration {

    @Bean
    public BadgeServiceImp badgeService() {
      return new BadgeServiceImp();
    }
  }
}

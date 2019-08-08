package com.greenfoxacademy.levelup.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.User;
import com.greenfoxacademy.levelup.repository.IUserRepository;
import com.greenfoxacademy.levelup.service.UserServiceImp;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserRestController.class, secure = false)
public class UserRestControllerTest {

  private User userOne;
  private User userTwo;
  private List<User> userList;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IUserRepository userRepository;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    userOne = new User("Bartok Bela", "bartok.bela@zeneakademia.hu", "user");
    userTwo = new User("Molnar Zsolt", "zsolt.molnar@greenfox.com", "admin");
    userList = new ArrayList<>();
    userList.add(userOne);
    userList.add(userTwo);
  }

  @Test
  public void testIfAuthorizationIsOKOnUserById_thenReturnsStatusOk() throws Exception {
    mockMvc.perform(get("/api/users/1")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(status().isOk())
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testIfAuthorizationIsOK_thenReturnUserById() throws Exception {
    when(userRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable((userOne)));

    mockMvc.perform(get("/api/users/1")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(
            content().string(new Gson().toJson(userOne)))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testIfAuthorizationOK_thenReturnsStatusOk() throws Exception {
    mockMvc.perform(get("/api/users")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(status().isOk())
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testIfAuthorizationOK_thenReturnsBadgesJsonObjects() throws Exception {
    when(userRepository.findAll()).thenReturn(userList);

    mockMvc.perform(get("/api/users")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(
            content().string(new Gson().toJson(userOne).concat("\n" + new Gson().toJson(userTwo))))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testWhenStatusIsUnauthorized_thenReturnsStatusUnauthorized() throws Exception {
    mockMvc.perform(get("/api/users")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(status().isUnauthorized())
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testWhenStatusIsUnauthorized_thenReturnsUnauthorizedErrorBody() throws Exception {
    mockMvc.perform(get("/api/users")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(content().string(Message.UNAUTHORIZED_BODY))
        .andDo(print())
        .andReturn();
  }

  @TestConfiguration
  static class UserServiceImpTestContextConfiguration {

    @Bean
    public UserServiceImp userService() {
      return new UserServiceImp();
    }
  }
}

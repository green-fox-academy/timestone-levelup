package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.User;
import java.util.List;
import javax.xml.ws.Response;
import org.springframework.http.ResponseEntity;

public interface IUserService {
  void save(User user);
  void delete(long id);
  List<User> findAll();
  User findById(long id);
  ResponseEntity<String> getUserJsonObjects(String authorization);
  ResponseEntity<String> getUserById(long id, String authorization);
}

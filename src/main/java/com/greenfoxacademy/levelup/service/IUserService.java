package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.User;
import java.util.List;

public interface IUserService {
  void save(User user);
  void delete(long id);
  List<User> findAll();
  User findById(long id);
}

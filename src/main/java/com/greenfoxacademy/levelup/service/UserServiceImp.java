package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.User;
import com.greenfoxacademy.levelup.repository.IUserRepository;
import com.greenfoxacademy.levelup.utility.Util;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService {

  private final IUserRepository personRepository;

  public UserServiceImp(IUserRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public void save(User user) {
    personRepository.save(user);
  }

  @Override
  public void delete(long id) {
    personRepository.delete(personRepository.findById(id).orElse(null));
  }

  @Override
  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    personRepository.findAll().forEach(users::add);
    return users;
  }

  @Override
  public User findById(long id) {
    return personRepository.findById(id).orElse(null);
  }

  @Override
  public ResponseEntity<String> getUserJsonObjects(String authorization) {
    if (authorization == null || !authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY, HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(Util.convertListOfUserToJson(findAll()), HttpStatus.OK);
  }
}

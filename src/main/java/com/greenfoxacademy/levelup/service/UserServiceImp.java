package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.User;
import com.greenfoxacademy.levelup.repository.IUserRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
    personRepository.delete(personRepository.findById(id).get());
  }

  @Override
  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    personRepository.findAll().forEach(person -> users.add(person));
    return users;
  }

  @Override
  public User findById(long id) {
    return personRepository.findById(id).get();
  }
}

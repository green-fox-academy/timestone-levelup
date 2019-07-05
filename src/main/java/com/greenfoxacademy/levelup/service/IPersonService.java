package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.Person;

import java.util.List;

public interface IPersonService {
  void save(Person person);
  void delete(long id);
  List<Person> findAll();
  Person findById(long id);
}

package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.Person;
import com.greenfoxacademy.levelup.repository.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImp implements IPersonService{

  private final IPersonRepository personRepository;

  public PersonServiceImp(IPersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public void save(Person person) {
    personRepository.save(person);
  }

  @Override
  public void delete(long id) {
    personRepository.delete(personRepository.findById(id).get());
  }

  @Override
  public List<Person> findAll() {
    List<Person> persons = new ArrayList<>();
    personRepository.findAll().forEach(person -> persons.add(person));
    return persons;
  }

  @Override
  public Person findById(long id) {
    return personRepository.findById(id).get();
  }
}

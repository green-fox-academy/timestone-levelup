package com.greenfoxacademy.levelup.repository;

import com.greenfoxacademy.levelup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends CrudRepository<User, Long> {

}
  
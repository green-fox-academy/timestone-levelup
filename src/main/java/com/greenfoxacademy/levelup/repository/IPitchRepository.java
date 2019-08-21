package com.greenfoxacademy.levelup.repository;

import com.greenfoxacademy.levelup.model.Pitch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPitchRepository extends CrudRepository<Pitch, Long> {

}

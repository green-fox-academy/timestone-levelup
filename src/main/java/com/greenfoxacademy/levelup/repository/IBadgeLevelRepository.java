package com.greenfoxacademy.levelup.repository;

import com.greenfoxacademy.levelup.model.BadgeLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBadgeLevelRepository extends CrudRepository<BadgeLevel, Long> {

}

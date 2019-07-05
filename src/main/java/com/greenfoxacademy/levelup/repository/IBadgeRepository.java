package com.greenfoxacademy.levelup.repository;

import com.greenfoxacademy.levelup.model.Badge;
import java.util.logging.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBadgeRepository extends CrudRepository<Badge, Level> {

}

package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.Pitch;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IPitchService {

  public List<Pitch> findAllPitches();
  public Pitch findPitchById(long id);
  ResponseEntity<String> getPitches(String authorization);
  ResponseEntity<String> getPitchById(long id, String authorization);
}

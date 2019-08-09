package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Pitch;
import com.greenfoxacademy.levelup.repository.IPitchRepository;
import com.greenfoxacademy.levelup.utility.Util;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PitchServiceImp implements IPitchService {

  @Autowired
  IPitchRepository pitchRepository;

  @Override
  public List<Pitch> findAllPitches() {
    List<Pitch> pitchList = new ArrayList<>();
    pitchRepository.findAll().forEach(pitchList::add);
    return pitchList;
  }

  @Override
  public Pitch findPitchById(long id) {
    return pitchRepository.findById(id).orElse(null);
  }

  @Override
  public ResponseEntity<String> getPitches(String authorization) {
    if (authorization == null || !authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY, HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(Util.convertListOfPitchToJson(findAllPitches()), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> getPitchById(long id, String authorization) {
    if (authorization == null || !authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY, HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(Util.convertModelToJson(findPitchById(id)), HttpStatus.OK);
  }
}

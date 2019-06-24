package com.greenfoxacademy.levelup.controller;



import com.greenfoxacademy.levelup.model.MockObjectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AddRestController {

  @PostMapping("api/admin/add")
  public ResponseEntity<String> addDTO(@RequestBody MockObjectDTO objectDTO) {
    List<MockObjectDTO> objects = new ArrayList<>(Arrays.asList());
    objects.add(objectDTO);
    if(objectDTO == null) {
      return new ResponseEntity<>("Please provide all fields", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Created", HttpStatus.CREATED);
  }
}



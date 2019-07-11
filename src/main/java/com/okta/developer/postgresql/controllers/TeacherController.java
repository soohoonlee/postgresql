package com.okta.developer.postgresql.controllers;

import com.okta.developer.postgresql.entities.Review;
import com.okta.developer.postgresql.service.TeacherService;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeacherController {

  private final TeacherService teacherService;

  @PostMapping("/teachers/{id}/review")
  public ResponseEntity addReview(@RequestBody Review review, @PathVariable("id") String teacherID) {
    try {
      teacherService.addReview(teacherID, review);
      return ResponseEntity.ok().build();
    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }
}

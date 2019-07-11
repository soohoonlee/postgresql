package com.okta.developer.postgresql.service;

import com.okta.developer.postgresql.entities.Review;
import javax.validation.constraints.NotNull;

public interface TeacherService {

  void addReview(@NotNull String teacherID, @NotNull Review review);
}

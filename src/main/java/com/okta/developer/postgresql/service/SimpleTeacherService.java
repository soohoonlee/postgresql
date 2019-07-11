package com.okta.developer.postgresql.service;

import com.okta.developer.postgresql.dao.TeacherDAO;
import com.okta.developer.postgresql.entities.Review;
import com.okta.developer.postgresql.entities.Teacher;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SimpleTeacherService implements TeacherService {

  private final TeacherDAO teacherDAO;

  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public void addReview(@NotNull String teacherID, @NotNull Review review) {
    Objects.requireNonNull(teacherID);
    Objects.requireNonNull(review);
    Teacher teacher = teacherDAO.findById(UUID.fromString(teacherID))
        .orElseThrow(() -> new EntityNotFoundException(teacherID));
//    Review.builder().date(LocalDate.now()).build();
    review.setDate(LocalDate.now());
    if (teacher.getReviews() == null) {
      teacher.setReviews(new ArrayList<>());
//      Teacher.builder().reviews(new ArrayList<>()).build();
    }
    teacher.getReviews().add(review);
    teacherDAO.save(teacher);
  }
}

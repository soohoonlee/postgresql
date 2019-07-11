package com.okta.developer.postgresql.service;

import com.okta.developer.postgresql.dao.CourseDAO;
import com.okta.developer.postgresql.dao.TeacherDAO;
import com.okta.developer.postgresql.entities.Course;
import com.okta.developer.postgresql.entities.Teacher;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DataFillerService {

  private final CourseDAO courseDAO;
  private final TeacherDAO teacherDAO;

//  @PostConstruct
  @Transactional
  public void fillData() {
    final Teacher pj = Teacher.builder()
        .name("Professor Jirafales")
        .pictureURL("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg")
        .email("jirafales@yahoo_.com")
        .build();

    final Teacher px = Teacher.builder()
        .name("Professor X")
        .pictureURL(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4")
        .email("director@xproject_.com")
        .build();
    teacherDAO.save(pj);
    teacherDAO.save(px);

    Course mathematics = Course.builder()
        .name("Mathematics")
        .workload(20)
        .rate((short) 10)
        .teacher(pj)
        .build();
    Course spanish = Course.builder()
        .name("Spanish")
        .workload(20)
        .rate((short) 10)
        .teacher(pj)
        .build();
    Course dealingWithUnknown = Course.builder()
        .name("Dealing with unknown")
        .workload(10)
        .rate((short) 100)
        .teacher(pj)
        .build();
    Course handlingYourMentalPower = Course.builder()
        .name("Handling your mental power")
        .workload(50)
        .rate((short) 100)
        .teacher(pj)
        .build();
    Course introductionToPsychology = Course.builder()
        .name("Introduction To Psychology")
        .workload(90)
        .rate((short) 100)
        .teacher(pj)
        .build();
    courseDAO.save(mathematics);
    courseDAO.save(spanish);
    courseDAO.save(dealingWithUnknown);
    courseDAO.save(handlingYourMentalPower);
    courseDAO.save(introductionToPsychology);
  }
}

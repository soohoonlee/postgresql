package com.okta.developer.postgresql.dao;

import com.okta.developer.postgresql.entities.Course;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CourseDAO extends CrudRepository<Course, UUID> {

}

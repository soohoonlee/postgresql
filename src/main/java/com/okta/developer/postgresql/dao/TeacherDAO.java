package com.okta.developer.postgresql.dao;

import com.okta.developer.postgresql.entities.Teacher;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface TeacherDAO extends CrudRepository<Teacher, UUID> {

}

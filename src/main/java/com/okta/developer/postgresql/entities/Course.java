package com.okta.developer.postgresql.entities;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course extends EntityWithUUID {

  private String name;
  private int workload;
  private short rate;

  @ManyToOne
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_course_teacher"))
  private Teacher teacher;
}

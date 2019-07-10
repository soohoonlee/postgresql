package com.okta.developer.postgresql.entities;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Teacher extends EntityWithUUID {

  private String name;
  private String pictureURL;
  private String email;

  @Builder
  public Teacher(String name, String pictureURL, String email) {
    this.name = name;
    this.pictureURL = pictureURL;
    this.email = email;
  }
}

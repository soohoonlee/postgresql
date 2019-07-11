package com.okta.developer.postgresql.entities;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review implements Serializable {

  private String author;
  private String review;
  private LocalDate date;
}

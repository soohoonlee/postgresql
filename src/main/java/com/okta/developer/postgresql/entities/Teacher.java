package com.okta.developer.postgresql.entities;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher extends EntityWithUUID {

  private String name;
  private String pictureURL;
  private String email;

  @Type(type = "jsonb")
  @Column(columnDefinition = "jsonb")
  @Basic(fetch = FetchType.LAZY)
  private List<Review> reviews;
}

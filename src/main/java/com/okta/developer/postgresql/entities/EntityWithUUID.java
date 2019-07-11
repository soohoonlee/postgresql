package com.okta.developer.postgresql.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@MappedSuperclass
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class EntityWithUUID {

  @Id @Type(type = "pg-uuid")
  private UUID id;

  public EntityWithUUID() {
    this.id = UUID.randomUUID();
  }
}

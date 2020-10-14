package com.example.Assignment.commons;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, GuidEntityListener.class})
public abstract class AbstractAuditionGuidKeyEntity extends AbstractAuditionEntity implements Serializable {
    @Id
    @Column(
            name = "id"
    )
    private String id;

    public AbstractAuditionGuidKeyEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}

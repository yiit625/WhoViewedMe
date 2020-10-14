package com.example.Assignment.commons;

import java.util.UUID;
import javax.persistence.PrePersist;

public class GuidEntityListener {
    public GuidEntityListener() {
    }

    @PrePersist
    public void onGuidPrePersist(final AbstractAuditionGuidKeyEntity entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID().toString());
        }

    }
}

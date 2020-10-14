package com.example.Assignment.commons;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@JsonIgnoreProperties(
        value = {"created_date", "last_modified_date"},
        allowGetters = true
)
public abstract class AbstractAuditionEntity {
    private static final long serialVersionUID = 1L;
    @Version
    @Column(
            name = "version",
            columnDefinition = "integer DEFAULT 0",
            nullable = false
    )
    protected Long version;


    @Column(
            name = "deleted"
    )
    private boolean deleted;

    public AbstractAuditionEntity() {
    }

    @PrePersist
    protected void onCreate() {
        this.version = 1L;
    }

    public Long getVersion() {
        return this.version;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setVersion(final Long version) {
        this.version = version;
    }

    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }
}

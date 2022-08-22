package org.worldline.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
    @Column(name = "creationDate")
    private Instant creationDate;

    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate;

    @PrePersist
    void prePersist() {
        creationDate = Instant.now();
    }

    @PreUpdate
    void preUpdate(){
        lastModifiedDate = Instant.now();
    }
}

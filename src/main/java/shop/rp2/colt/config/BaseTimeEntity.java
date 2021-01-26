package shop.rp2.colt.config;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseTimeEntity {
//    @Getter
//    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
//    @Temporal(TIMESTAMP)
    @CreationTimestamp
    @Column(name = "registed_date", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

//    @Getter
//    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
//    @Temporal(TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

//    @PrePersist
//    void prePersist() {
//        this.createdAt = this.updatedAt = new Date();
//    }
//
//    @PreUpdate
//    void preUpdate() {
//        this.updatedAt = new Date();
//    }
}
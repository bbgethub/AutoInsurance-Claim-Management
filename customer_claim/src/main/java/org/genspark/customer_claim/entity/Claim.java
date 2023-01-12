package org.genspark.customer_claim.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
@Entity
@Table(name="claim")
@AllArgsConstructor
@NoArgsConstructor
public class Claim {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Getter
    @Setter
    @Column(name="amount")
    private int amount;
    @Getter
    @Setter
    @Column(name="policyNumber")
    private int policyNumber;
    @Getter
    @Setter
    @CreationTimestamp
    @Column(name="created")
    private LocalDate created;
    @Getter
    @Setter
    @CreationTimestamp
    @Column(name="lastModified")
    private LocalDate lastModified;
    @Getter
    @Setter
    @Column(name="status")
    private String status;
    @Getter
    @Setter
    @Column(name="notes")
    private String notes;

}

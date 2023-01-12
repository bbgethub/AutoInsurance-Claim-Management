package org.genspark.customer_claim.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="policy")
@AllArgsConstructor
@NoArgsConstructor
public class Policy {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="number")
    private int number;

    @Getter
    @Setter
    @Column(name="type")
    private String type;
    @Getter
    @Setter
    @Column(name="customerid")
    private int customerid;

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
}

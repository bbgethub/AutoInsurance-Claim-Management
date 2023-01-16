package org.genspark.customer_claim.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Getter
    @Setter
    @Column(name="firstname")
    private String firstname;
    @Getter
    @Setter
    @Column(name="lastname")
    private String lastname;


    @Getter
    @Setter
    @Column(name="dob")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dob;
    @Getter
    @Setter
    @Column(name="address")
    private String address;
    @Getter
    @Setter
    @Column(name="phone")
    private long phone;

    @Getter
    @Setter
    @Column(name="email")
    private String email;

    @Getter
    @Setter
    @Column(name="gender")
    private String gender;
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

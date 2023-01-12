package org.genspark.customer_claim.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="claim_mgnt_document_tbl")
public class Document {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Column(name="id")
    private int id;
    @Getter
    @Setter
    @Column(name="customer_id")
    private int customerId;
    @Setter
    @Getter
    @Column(name="name")
    private String name;
    @Setter
    @Getter
    @Column(name="type")
    private String type;
    @Setter
    @Getter
    @Column(name="document")
    @Lob
    private byte[] document;
}

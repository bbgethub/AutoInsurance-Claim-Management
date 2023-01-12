package org.genspark.customer_claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.genspark.customer_claim.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long> {
}

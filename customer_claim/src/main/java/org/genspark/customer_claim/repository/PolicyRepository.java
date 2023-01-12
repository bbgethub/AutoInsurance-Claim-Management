package org.genspark.customer_claim.repository;

import org.genspark.customer_claim.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Long>
{
}
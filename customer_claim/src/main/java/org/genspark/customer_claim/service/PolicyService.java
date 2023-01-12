package org.genspark.customer_claim.service;

import org.genspark.customer_claim.entity.Claim;
import org.genspark.customer_claim.entity.Policy;
import org.genspark.customer_claim.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyService {
    @Autowired
    PolicyRepository repository;

    public Optional<Policy> getPolicy(Long id)
    {
        return repository.findById(id);
    }

    public Policy createPolicy(Policy policy)
    {
        System.out.println("Inside Claim createClaim");
        return repository.save(policy);
    }
}

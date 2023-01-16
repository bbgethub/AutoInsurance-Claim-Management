package org.genspark.customer_claim.service;

import org.genspark.customer_claim.entity.Claim;
import org.genspark.customer_claim.entity.Customer;
import org.genspark.customer_claim.entity.Document;
import org.genspark.customer_claim.entity.Policy;
import org.genspark.customer_claim.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {
    @Autowired
    PolicyRepository repository;

    public Optional<Policy> getPolicy(Integer id)
    {
        return repository.findById(id);
    }

    public Policy createPolicy(Policy policy)
    {
        System.out.println("Inside Claim createClaim");
        return repository.save(policy);
    }

    public List<Policy> getAllPolicies()
    {
        return repository.findAll();
    }

    public void deletePolicy(Integer id) {
        repository.deleteById(id);
    }

    public  List<Policy> getPoliciesByIds(List<Integer> ids)
    {
        return repository.findAllById(ids);
    }

    public Policy updatePolicy(Integer id,Policy inputPolicy) {
        Policy policy= repository.findById(id).get();
        policy.setCustomerid(inputPolicy.getCustomerid());
        policy.setType(inputPolicy.getType());
        return repository.save(policy);
    }
}

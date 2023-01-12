package org.genspark.customer_claim.service;

import org.genspark.customer_claim.entity.Claim;
import org.genspark.customer_claim.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {
    @Autowired
    ClaimRepository claimRepository;
    public Claim createClaim(Claim claim)
    {
        System.out.println("Inside Claim createClaim");
        return claimRepository.save(claim);
    }
    public List<Claim> getAllClaims()
    {
        return claimRepository.findAll();
    }
    public Optional<Claim> getSingleClaimById(Long id)
    {
        return claimRepository.findById(id);
    }

    public Claim updateCustomerClaim(Long id,Claim claim) {
        Claim updateCustomerClaim= claimRepository.findById(id).get();
        updateCustomerClaim.setPolicyNumber(claim.getPolicyNumber());
        updateCustomerClaim.setAmount(claim.getAmount());
        updateCustomerClaim.setStatus(claim.getStatus());
        updateCustomerClaim.setNotes(claim.getNotes());
        return claimRepository.save(updateCustomerClaim);
    }

    public void deleteClaimDocument(Long id) {
        claimRepository.deleteById(id);
    }
}

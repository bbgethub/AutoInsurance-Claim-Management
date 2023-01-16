package org.genspark.customer_claim.controller;

import org.genspark.customer_claim.entity.Claim;
import org.genspark.customer_claim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/claim")
public class ClaimController {
    @Autowired
    ClaimService claimService;
    //Create New Claim
    @CrossOrigin
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public Claim createNewClaim(@RequestBody Claim claim)
    {
        return claimService.createClaim(claim);
    }
    //View All Claims
    @CrossOrigin
    @RequestMapping(value="/getAll", method= RequestMethod.GET)
    public List<Claim> getAllClaims()
    {
        return claimService.getAllClaims();
    }

    @CrossOrigin
    @RequestMapping(value = "/getFor", params = "ids", method = RequestMethod.GET)
    public List<Claim> getAllClaimsByIds(@PathVariable List<Long> ids)
    {
        return claimService.getClaimsByIds(ids);
    }
    //View By Customer Claim Id
    @CrossOrigin
    @RequestMapping(value="/{customerClaimId}", method= RequestMethod.GET)
    public Optional<Claim> getCustomerClaimById(@PathVariable("customerClaimId")Long id)
    {
        return claimService.getSingleClaimById(id);
    }
    @CrossOrigin
    @RequestMapping(value="/{customerClaimId}",method=RequestMethod.PUT)
    public Claim updateCustomerClaim(@PathVariable("customerClaimId")Long id,@RequestBody Claim claim)
    {
        return claimService.updateCustomerClaim(id,claim);
    }
    @CrossOrigin
    @RequestMapping(value="/{customerClaimId}", method= RequestMethod.DELETE)
    public void deleteClaimDocument(@PathVariable("customerClaimId")Long id)
    {
        claimService.deleteClaimDocument(id);
    }

}

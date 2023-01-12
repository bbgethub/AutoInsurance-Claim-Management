package org.genspark.customer_claim.controller;

import org.genspark.customer_claim.entity.Claim;
import org.genspark.customer_claim.entity.Policy;
import org.genspark.customer_claim.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {
    @Autowired
    PolicyService service;

    @RequestMapping(value = "/{policyId}",method=RequestMethod.GET)
    public Optional<Policy> getDocument(@PathVariable(value = "policyId")Long id)
    {
        return service.getPolicy(id);
    }
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public Policy createNewClaim(@RequestBody Policy policy)
    {
        return service.createPolicy(policy);
    }
}

package org.genspark.customer_claim.controller;

import org.genspark.customer_claim.entity.Claim;
import org.genspark.customer_claim.entity.Customer;
import org.genspark.customer_claim.entity.Policy;
import org.genspark.customer_claim.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {
    @Autowired
    PolicyService service;
    @CrossOrigin
    @RequestMapping(value = "/{policyId}",method=RequestMethod.GET)
    public Optional<Policy> getDocument(@PathVariable(value = "policyId")Integer id)
    {
        return service.getPolicy(id);
    }
    @CrossOrigin
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public Policy createNewClaim(@RequestBody Policy policy)
    {
        return service.createPolicy(policy);
    }
    @CrossOrigin
    @RequestMapping(value="/getAll", method= RequestMethod.GET)
    public List<Policy> getAll()
    {
        return service.getAllPolicies();
    }
    @CrossOrigin
    @RequestMapping(value="/{Id}",method=RequestMethod.DELETE)
    public void deletePolicy(@PathVariable("Id")Integer id){

        service.deletePolicy(id);
    }
    @CrossOrigin
    @RequestMapping(value = "/getFor/{ids}", method = RequestMethod.GET)
    public List<Policy> getPoliciesByIds(@PathVariable List<Integer> ids)
    {
        return service.getPoliciesByIds(ids);
    }
    @CrossOrigin
    @RequestMapping(value="/{policyId}",method=RequestMethod.PUT)
    public Policy updatePolicy(@PathVariable("policyId")Integer id,@RequestBody Policy policy)
    {
        return service.updatePolicy(id,policy);
    }
}

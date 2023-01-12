package org.genspark.customer_claim.controller;

import org.genspark.customer_claim.entity.Claim;
import org.genspark.customer_claim.entity.Customer;
import org.genspark.customer_claim.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    @RequestMapping(value = "/{custId}",method=RequestMethod.GET)
    public Optional<Customer> getCustomer(@PathVariable(value = "custId")Long id)
    {
        return service.getCustomer(id);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return service.createCustomer(customer);
    }

}

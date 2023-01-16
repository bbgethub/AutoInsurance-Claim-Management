package org.genspark.customer_claim.controller;

import org.genspark.customer_claim.entity.Claim;
import org.genspark.customer_claim.entity.Customer;
import org.genspark.customer_claim.entity.Policy;
import org.genspark.customer_claim.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    @CrossOrigin
    @RequestMapping(value = "/{custId}",method=RequestMethod.GET)
    public Optional<Customer> getCustomer(@PathVariable(value = "custId")Integer id)
    {
        return service.getCustomer(id);
    }
    @CrossOrigin
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return service.createCustomer(customer);
    }
    @CrossOrigin
    @RequestMapping(value="/getAll", method= RequestMethod.GET)
    public List<Customer> getAll()
    {
        return service.getAllCustomers();
    }
    @CrossOrigin
    @RequestMapping(value="/{Id}",method=RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("Id")Integer id){

        service.deleteCustomer(id);
    }
    @CrossOrigin
    @RequestMapping(value = "/getFor/{ids}", method = RequestMethod.GET)
    public List<Customer> getCustomersByIds(@PathVariable List<Integer> ids)
    {
        return service.getCustomersByIds(ids);
    }
}

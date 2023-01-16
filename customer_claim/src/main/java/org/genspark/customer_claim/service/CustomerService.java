package org.genspark.customer_claim.service;

import org.genspark.customer_claim.entity.Claim;
import org.genspark.customer_claim.entity.Customer;
import org.genspark.customer_claim.entity.Policy;
import org.genspark.customer_claim.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public Optional<Customer> getCustomer(Integer id)
    {
        return repository.findById(id);
    }

    public Customer createCustomer(Customer customer)    {

        return repository.save(customer);
    }
    public List<Customer> getAllCustomers()
    {
        return repository.findAll();
    }

    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    public  List<Customer> getCustomersByIds(List<Integer> ids)
    {
        return repository.findAllById(ids);
    }
}

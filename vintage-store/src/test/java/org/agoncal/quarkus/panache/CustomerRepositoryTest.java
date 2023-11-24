package org.agoncal.quarkus.panache;

import org.agoncal.quarkus.jpa.Customer;
import org.agoncal.quarkus.panache.customer.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class CustomerRepositoryTest {

    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAnCustomer() {
        Customer customer = new Customer("Customer 1", "ctm1@gmail.com");

        customerRepository.persist(customer);
        Assertions.assertNotNull(customer.getId());

        Customer foundCustomer = customerRepository.findById(customer.getId());

        Assertions.assertEquals("ctm1@gmail.com", foundCustomer.getEmail());

    }
}

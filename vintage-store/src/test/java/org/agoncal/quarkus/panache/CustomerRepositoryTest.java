package org.agoncal.quarkus.panache;

import org.agoncal.quarkus.jpa.Customer;
import org.agoncal.quarkus.panache.customer.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;

@QuarkusTest
public class CustomerRepositoryTest {

    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAnCustomer() {
        long count = customerRepository.count();
        long listAllSize = customerRepository.listAllSorted().size();
        Assertions.assertEquals(count, listAllSize);
        Customer customer = new Customer("Customer 1", "ctm1@gmail.com");

        customerRepository.persist(customer);
        Assertions.assertNotNull(customer.getId());

        Assertions.assertEquals(count + 1, customerRepository.count());

        Assertions.assertEquals(count + 1, customerRepository.listAllWithName("Customer 1").size());

        Customer foundCustomer = customerRepository.findById(customer.getId());

        var foundCustomerWithName = customerRepository.getCustomerWithName("Customer 1")
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertEquals(foundCustomerWithName.getEmail(), foundCustomer.getEmail());

        customerRepository.deleteById(foundCustomer.getId());
        Assertions.assertEquals(count, customerRepository.count());
    }
}

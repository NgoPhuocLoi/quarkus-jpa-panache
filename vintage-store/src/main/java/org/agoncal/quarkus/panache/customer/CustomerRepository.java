package org.agoncal.quarkus.panache.customer;

import java.util.List;
import java.util.Optional;

import org.agoncal.quarkus.jpa.Customer;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    public List<Customer> listAllSorted() {
        return listAll(Sort.descending("name"));
    }

    public List<Customer> listAllWithName(String name) {
        return list("name LIKE ?1", "%" + name + "%");
    }

    public Optional<Customer> getCustomerWithName(String name) {
        return find("name = ?1", name).firstResultOptional();
    }
}

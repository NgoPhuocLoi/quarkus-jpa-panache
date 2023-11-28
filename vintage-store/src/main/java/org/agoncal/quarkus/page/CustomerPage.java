package org.agoncal.quarkus.page;

import io.quarkus.panache.common.Sort;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

import java.util.List;

import org.agoncal.quarkus.jpa.Customer;
import org.agoncal.quarkus.panache.customer.CustomerRepository;

@Path("/page/customers")
public class CustomerPage {
    @Inject
    CustomerRepository customerRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance customers(List<Customer> customers);

        public static native TemplateInstance customer(Customer customer);
    }

    @GET
    @Path("{id}")
    public TemplateInstance showCustomerById(@PathParam("id") Long id) {
        return Templates.customer(customerRepository.findById(id));
    }

    @GET
    public TemplateInstance showCustomers(
            @QueryParam("query") String query,
            @QueryParam("sort") @DefaultValue("id") String sort,
            @QueryParam("page") @DefaultValue("0") int pageIndex,
            @QueryParam("size") @DefaultValue("10") int size) {
        return Templates.customers(customerRepository.find(query, Sort.by(sort)).page(pageIndex, size).list());
    }
}

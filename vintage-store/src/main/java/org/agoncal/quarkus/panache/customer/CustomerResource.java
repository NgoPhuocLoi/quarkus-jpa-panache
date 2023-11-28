package org.agoncal.quarkus.panache.customer;

import java.util.List;

import org.agoncal.quarkus.jpa.Customer;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/api/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @GET
    public List<Customer> getAllCustomers() {
        return customerRepository.listAll();
    }

    @POST
    @Transactional
    public Response persistCustomer(Customer c, @Context UriInfo uriInfo) {
        System.out.println(uriInfo);

        customerRepository.persist(c);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(c.getId()));
        return Response.created(uriBuilder.build()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void removeCustomer(@PathParam("id") Long id) {
        customerRepository.deleteById(id);
    }
}

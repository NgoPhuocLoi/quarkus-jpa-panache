package org.agoncal.quarkus.panache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PublisherTest {
    @Test
    @TestTransaction
    public void shouldCreateAndFindAPublisher() {
        Publisher publisher = new Publisher("Publisher 1");
        Publisher.persist(publisher);
        Assertions.assertNotNull(publisher.id);

        Publisher foundPublisher = Publisher.findById(publisher.id);
        Assertions.assertEquals("Publisher 1", foundPublisher.name);
    }
}

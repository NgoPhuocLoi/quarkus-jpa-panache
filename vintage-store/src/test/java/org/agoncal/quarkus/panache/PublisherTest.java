package org.agoncal.quarkus.panache;

import org.agoncal.quarkus.panache.publisher.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PublisherTest {
    @Test
    @TestTransaction
    public void shouldCreateAndFindAPublisher() {
        long count = Publisher.count();
        long listAllSize = Publisher.listAll().size();

        Assertions.assertEquals(count, listAllSize);

        Publisher publisher = new Publisher("Publisher 1");
        Publisher.persist(publisher);
        Assertions.assertNotNull(publisher.id);
        Assertions.assertEquals(count + 1, Publisher.count());

        Publisher foundPublisher = Publisher.findById(publisher.id);
        Assertions.assertEquals("Publisher 1", foundPublisher.name);
        Publisher.deleteById(foundPublisher.id);
        Assertions.assertEquals(count, Publisher.count());
    }
}

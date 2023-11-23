package org.agoncal.quarkus.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TestArtistRepository {
    @Test
    public void TC1() {
        int result = 10;
        Assertions.assertEquals(result, 5 + 5);

    }
}

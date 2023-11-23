package org.agoncal.quarkus.jdbc;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ArtistRepositoryTest {
    @Inject
    ArtistRepository artistRepository;

    @Test
    public void shouldCreateAndFindAnArtist() throws SQLException {
        Artist artist = new Artist("Artist A", "Bio of Artist A");
        artistRepository.persist(artist);

        Assertions.assertNotNull(artist.getId());

        var foundArtist = artistRepository.findById(artist.getId());
        Assertions.assertEquals("Artist A", foundArtist.getName());
    }
}

package org.agoncal.quarkus.panache;

import java.sql.SQLException;

import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.panache.artist.ArtistRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ArtistRepositoryTest {
    @Inject
    ArtistRepository artistRepository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAnArtist() throws SQLException {
        long count = artistRepository.count();
        long listAllSize = artistRepository.listAll().size();

        Assertions.assertEquals(count, listAllSize);
        Artist artist = new Artist("Artist A", "Bio of Artist A");
        artistRepository.persist(artist);

        Assertions.assertEquals(count + 1, artistRepository.count());
        Assertions.assertNotNull(artist.getId());

        var foundArtist = artistRepository.findById(artist.getId());
        Assertions.assertEquals("Artist A", foundArtist.getName());

        artistRepository.deleteById(foundArtist.getId());
        Assertions.assertEquals(count, artistRepository.count());

    }
}

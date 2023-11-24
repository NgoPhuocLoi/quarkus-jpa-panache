package org.agoncal.quarkus.panache.item;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_cds")
public class CD extends Item {
    @Column(name = "music_company ")
    public String musicCompany;

    @Column(length = 100)
    public String genre;

    @OneToMany(mappedBy = "cd")
    public List<Track> tracks = new ArrayList<>();

    public CD(String musicCompany, String genre) {
        this.musicCompany = musicCompany;
        this.genre = genre;
    }

    public CD() {
    }

}

package org.agoncal.quarkus.panache.item;

import java.math.BigDecimal;
import java.time.Instant;

import org.agoncal.quarkus.jdbc.Artist;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_items")
@Inheritance
public class Item extends PanacheEntity {
    @Column(length = 1000, nullable = false)
    public String title;

    @Column(length = 3000)
    public String description;

    @Column(nullable = false)
    public BigDecimal price;

    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "artist_id")
    public Artist artist;

    public Item(String title, String description, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Item() {
    }

}

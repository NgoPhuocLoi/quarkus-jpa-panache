package org.agoncal.quarkus.panache.item;

import java.time.LocalDate;

import org.agoncal.quarkus.panache.publisher.Publisher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_books")
public class Book extends Item {
    @Column(length = 15)
    public String isbn;

    @Column(name = "nb_of_pages")
    public Integer nbOfPages;

    @Column(name = "publication_date")
    public LocalDate publicationDate;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    public Language language;

    @ManyToOne
    public Publisher publisher;

    public Book(String isbn, Integer nbOfPages, LocalDate publicationDate) {
        this.isbn = isbn;
        this.nbOfPages = nbOfPages;
        this.publicationDate = publicationDate;
    }

    public Book() {
    }

}

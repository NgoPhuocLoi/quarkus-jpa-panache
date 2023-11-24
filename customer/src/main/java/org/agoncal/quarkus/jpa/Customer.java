package org.agoncal.quarkus.jpa;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Example JPA entity.
 *
 * To use it, get access to a JPA EntityManager via injection.
 *
 * {@code
 * @Inject
 * EntityManager em;
 *
 * public void doSomething() {
 * MyEntity entity1 = new MyEntity();
 * entity1.field = "field-1";
 * em.persist(entity1);
 *
 * List<MyEntity> entities = em.createQuery("from MyEntity",
 * MyEntity.class).getResultList();
 * }
 * }
 */
@Entity
@Table(name = "t_customers")
public class Customer {
    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 50, nullable = false)
    public String name;
    @Column(length = 100, unique = true, nullable = false)
    public String email;
    @Column(name = "created_date")
    public Instant createdDate = Instant.now();

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

}

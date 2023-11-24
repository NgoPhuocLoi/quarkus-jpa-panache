package org.agoncal.quarkus.panache.order;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.agoncal.quarkus.jpa.Customer;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_purchase_orders")
public class PurchaseOrder extends PanacheEntity {
    @Column(name = "purchase_order_date")
    public LocalDate date = LocalDate.now();

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Customer customer;

    @OneToMany(mappedBy = "order", cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
    public List<OrderLine> orderLines = new ArrayList<>();

    @Column(name = "created_date")
    public Instant createdDate = Instant.now();
}

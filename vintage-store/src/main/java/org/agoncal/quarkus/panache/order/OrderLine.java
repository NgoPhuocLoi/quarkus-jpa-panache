package org.agoncal.quarkus.panache.order;

import java.time.Instant;

import org.agoncal.quarkus.panache.item.Item;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_purchase_order_lines")
public class OrderLine extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    public PurchaseOrder order;

    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();
}

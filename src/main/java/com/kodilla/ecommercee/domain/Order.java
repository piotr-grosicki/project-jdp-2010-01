package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
public class Order {

    private Long id;
    private Long cartId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    public Order(Long id, Long cartId, LocalDate orderDate) {
        this.id = id;
        this.cartId = cartId;
        this.orderDate = orderDate;
    }

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

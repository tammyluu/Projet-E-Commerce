package com.example.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dateOrder;

    private StatusOrder statusOrder;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    @JsonIgnore
    private Consumer consumer;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<Cart> cart = new ArrayList<>();
}

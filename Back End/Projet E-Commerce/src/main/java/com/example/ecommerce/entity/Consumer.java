package com.example.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "need a fullName")
    private String fullName ;

    @Column(unique = true)
    @Email(message = "email valid")
    private String email ;

    @NotBlank(message = "need a password")
    private String password ;

    @NotBlank(message = "need an address")
    private String address ;

    @OneToMany(mappedBy = "consumer")
    private List<Order> orders = new ArrayList<>();

}

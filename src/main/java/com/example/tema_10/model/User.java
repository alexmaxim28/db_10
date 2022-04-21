package com.example.tema_10.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // Fiecare User poate avea un singur cart
    @OneToOne
    Cart cart;

    // Fiecare User poate avea un singur wishlist
    @OneToOne
    Wishlist wishlist;
}

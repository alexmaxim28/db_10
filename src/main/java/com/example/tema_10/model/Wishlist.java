package com.example.tema_10.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wishlist {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    List<Product> prodInCart;

    @OneToOne
    User user;

    @OneToMany
    List<Product> prodInWishlist;
}

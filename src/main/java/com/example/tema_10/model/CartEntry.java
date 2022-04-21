package com.example.tema_10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartEntry {
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;

    @ManyToOne
    private Product product;
    @ManyToOne
    @JsonIgnore
    private Cart cart;
}
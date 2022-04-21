package com.example.tema_10.controller;

import com.example.tema_10.model.Cart;
import com.example.tema_10.model.CartEntry;
import com.example.tema_10.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/carts")
    public List<Cart> getAllUserCarts() { return cartService.getAllCarts(); }

    @GetMapping("/carts/{id}")
    public Cart getCartById(@PathVariable Long id) { return cartService.getCartById(id); }

    @DeleteMapping("/carts/delete/{id}")
    public String deleteCart(@PathVariable Long id) {
        cartService.getCartById(id).setCartEntries(new ArrayList<CartEntry>());
        return "Cart is now empty.";
    }

    @PostMapping("/carts/addProduct/{idUser}/{idProduct}/{quantity}")
    public String addProductInCart(@PathVariable Long idUser, @PathVariable Long idProduct, @PathVariable int quantity){
        cartService.addProductInCart(idUser, idProduct, quantity);
        return "Product added in cart.";
    }

    @PostMapping("/carts/deleteProduct/{}")
}

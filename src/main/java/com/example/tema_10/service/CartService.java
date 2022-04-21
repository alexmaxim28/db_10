package com.example.tema_10.service;

import com.example.tema_10.model.*;
import com.example.tema_10.repository.CartRepository;
import com.example.tema_10.repository.ProductRepository;
import com.example.tema_10.repository.UserRepository;
import com.example.tema_10.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public Cart getCartById(Long id) { return cartRepository.getById(id); }

    public List<Cart> getAllCarts() { return cartRepository.findAll(); }

    public void addCart(Cart cart) { cartRepository.save(cart); }

    public void removeCart(Cart cart) {
        cartRepository.delete(cart);
    }

    public void deleteCartById(Long id) { cartRepository.delete(getCartById(id)); }

    public Cart addProductInCart(Long idUser, Long idProduct, int quantity) {
        Product p = productRepository.getById(idProduct);
        User u = userRepository.getById(idUser);
        Cart cart = u.getCart();

        for (CartEntry ce : cart.getCartEntries()) {
            if (ce.getProduct().getId().equals(idProduct)) {
                ce.setQuantity(ce.getQuantity() + quantity);
                return cartRepository.save(cart);
            }
        }

        CartEntry cartEntry = new CartEntry();
        cartEntry.setCart(cart);
        cartEntry.setProduct(p);
        cartEntry.setQuantity(quantity);

        cart.getCartEntries().add(cartEntry);

        return cartRepository.save(cart);
    }

    public Cart removeProductFromCart(Long idUser, Long idProduct){
        Product p = productRepository.getById(idProduct);
        User u = userRepository.getById(idUser);
        Cart cart = u.getCart();

        cart.getCartEntries().remove(p);
        return cartRepository.save(cart);
    }
}

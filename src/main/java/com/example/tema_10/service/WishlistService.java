package com.example.tema_10.service;

import com.example.tema_10.model.Product;
import com.example.tema_10.model.User;
import com.example.tema_10.model.Wishlist;
import com.example.tema_10.repository.ProductRepository;
import com.example.tema_10.repository.UserRepository;
import com.example.tema_10.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public Wishlist getWishlistById(Long id) { return wishlistRepository.getById(id); }

    public List<Wishlist> getAllWishlists() { return wishlistRepository.findAll(); }

    public void addWishlist(Wishlist wishlist) { wishlistRepository.save(wishlist); }

    public void deleteWishlist(Long id) { wishlistRepository.delete(getWishlistById(id)); }

    public Wishlist addProductInWishlist(Long idUser, Long idProduct){
        Product p = productRepository.getById(idProduct);
        User u = userRepository.getById(idUser);
        Wishlist wishlist =  u.getWishlist();
        wishlist.getProdInWishlist().add(p);
        return wishlistRepository.save(wishlist);
    }

    public Wishlist removeProductFromWishlist(Long idUser, Long idProduct){
        Product p = productRepository.getById(idProduct);
        User u = userRepository.getById(idUser);
        Wishlist wishlist =  u.getWishlist();
        wishlist.getProdInWishlist().remove(p);
        return wishlistRepository.save(wishlist);
    }
}

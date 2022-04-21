package com.example.tema_10.controller;

import com.example.tema_10.model.Wishlist;
import com.example.tema_10.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WishlistController {
    private final WishlistRepository wishlistRepository;


}

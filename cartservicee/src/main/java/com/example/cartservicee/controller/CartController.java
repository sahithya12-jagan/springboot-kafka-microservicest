package com.example.cartservicee.controller;

import com.example.cartservicee.dto.CartDto;
import com.example.cartservicee.model.Cart;
import com.example.cartservicee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
 private CartService cartService;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody CartDto cartDto) {
        Cart cart = new Cart();
        cart.setUserId(cartDto.getUserId());
        cart.setProductId(cartDto.getProductId());
        cart.setQuantity(cartDto.getQuantity());

        return cartService.addToCart(cart);
    }

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId) {
        return cartService.getCartByUser(userId);
    }

    @DeleteMapping("/{cartId}")
    public void removeItem(@PathVariable Long cartId) {
        cartService.removeItem(cartId);
    }

    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
    }
}

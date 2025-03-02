package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.entity.Items;
import com.project.ecommerce.repository.CartRepository;
import com.project.ecommerce.repository.ItemsRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CartController {

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long itemId) {
        Optional<Items> opItems = itemsRepository.findById(itemId);
        if(opItems.isPresent()) {
            Items items = opItems.get();
            Cart cart = new Cart();
            cart.setItems(items);
            cartRepository.save(cart);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getCart(Model model){
        List<Cart> cartList = cartRepository.findAll();
        List<Items> itemsList = cartList.stream().map(Cart::getItems).collect(Collectors.toList());
        double totalPrice = itemsList.stream().mapToDouble(Items::getPrice).sum();
        model.addAttribute("itemsList", itemsList);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @PostMapping("/cart/checkout")
    public String removeFromCart() {
        cartRepository.deleteAll();
        return "redirect:/products-category";
    }
}

package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Items;
import com.project.ecommerce.entity.ItemsCategory;
import com.project.ecommerce.repository.ItemsCategoryRepository;
import com.project.ecommerce.services.ItemsCategoryService;
import com.project.ecommerce.services.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ItemsController {

    private ItemsService itemsService;
    private ItemsCategoryRepository itemsCategoryRepository;
    public ItemsController(ItemsService itemsService, ItemsCategoryRepository itemsCategoryRepository){
        this.itemsService = itemsService;
        this.itemsCategoryRepository = itemsCategoryRepository;
    }

    @GetMapping("/products-category/{id}")
    public String getItemsByCategory(Model model, @PathVariable Long id){
        ItemsCategory itemsCategory = itemsCategoryRepository.findById(id).get();
        List<Items> items = itemsService.findByItemsCategory(itemsCategory);
        model.addAttribute("items", items);
        return "products";
    }
}

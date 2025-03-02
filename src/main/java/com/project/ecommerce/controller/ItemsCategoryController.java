package com.project.ecommerce.controller;

import com.project.ecommerce.entity.ItemsCategory;
import com.project.ecommerce.services.ItemsCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemsCategoryController {

    private ItemsCategoryService itemsCategoryService;

    public ItemsCategoryController(ItemsCategoryService itemsCategoryService) {
        this.itemsCategoryService = itemsCategoryService;
    }

    @PostMapping("/items_category_save")
    public ResponseEntity<?> saveItemsCategory(@RequestBody ItemsCategory itemsCategory){
        itemsCategoryService.save(itemsCategory);
        return ResponseEntity.ok().body("Items category saved successfully!");
    }

    @GetMapping("/products-category")
    public String getItemsCategory(Model model){
        List<ItemsCategory> itemsCategory = itemsCategoryService.findAll();
        model.addAttribute("items_category", itemsCategory);
        return "products-category";
    }

}

package com.project.ecommerce.services;

import com.project.ecommerce.entity.ItemsCategory;
import com.project.ecommerce.repository.ItemsCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsCategoryService{

    private ItemsCategoryRepository itemsCategoryRepository;

    public ItemsCategoryService(ItemsCategoryRepository itemsCategoryRepository){
        this.itemsCategoryRepository = itemsCategoryRepository;
    }

    public ItemsCategory save(ItemsCategory category){
        return itemsCategoryRepository.save(category);
    }

    public ItemsCategory findById(Long id){
        return itemsCategoryRepository.findById(id).orElse(null);
    }

    public List<ItemsCategory> findAll() {
        return itemsCategoryRepository.findAll();
    }
}

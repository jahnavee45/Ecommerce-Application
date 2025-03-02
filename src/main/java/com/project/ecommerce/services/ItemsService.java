package com.project.ecommerce.services;

import com.project.ecommerce.entity.Items;
import com.project.ecommerce.entity.ItemsCategory;
import com.project.ecommerce.repository.ItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService{

    private ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    public Items save(Items items) {
        return itemsRepository.save(items);
    }

    public Items findById(Long id) {
        return itemsRepository.findById(id).orElse(null);
    }

    public List<Items> findAll() {
        return itemsRepository.findAll();
    }

    public List<Items> findByItemsCategory(ItemsCategory itemsCategory) {
        return itemsRepository.findByItemsCategory(itemsCategory);
    }
}

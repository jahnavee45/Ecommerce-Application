package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Items;
import com.project.ecommerce.entity.ItemsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Long> {
    List<Items> findByItemsCategory(ItemsCategory itemsCategory);
}
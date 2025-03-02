package com.project.ecommerce.repository;

import com.project.ecommerce.entity.ItemsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsCategoryRepository extends JpaRepository<ItemsCategory, Long> {
}
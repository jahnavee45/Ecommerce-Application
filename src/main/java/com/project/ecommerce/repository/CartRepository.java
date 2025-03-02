package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}

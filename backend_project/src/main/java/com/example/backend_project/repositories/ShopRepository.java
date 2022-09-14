package com.example.backend_project.repositories;

import com.example.backend_project.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository <Shop, Long> {
}

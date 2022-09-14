package com.example.backend_project.repositories;

import com.example.backend_project.models.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}

package com.example.backend_project.repositories;

import com.example.backend_project.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}

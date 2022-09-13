package com.example.backend_project.repositories;

import com.example.backend_project.models.Battle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BattleRepository extends JpaRepository<Battle, Long> {

    List<Battle> countByVictoriousTrue();

}

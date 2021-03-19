package org.example.repos;

import org.example.domain.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdressRepo extends JpaRepository<Adress, Long>{
    List<Adress> findAll();
}

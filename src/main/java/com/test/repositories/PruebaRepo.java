package com.test.repositories;

import com.test.models.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepo extends JpaRepository<Prueba, Long> {
}

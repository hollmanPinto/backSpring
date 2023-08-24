package com.test.test.repositories;

import com.test.test.models.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoMain extends JpaRepository<Prueba, Long> {
}

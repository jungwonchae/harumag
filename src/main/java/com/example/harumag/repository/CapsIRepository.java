package com.example.harumag.repository;

import com.example.harumag.domain.CapsI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapsIRepository extends JpaRepository<CapsI, String> {
}

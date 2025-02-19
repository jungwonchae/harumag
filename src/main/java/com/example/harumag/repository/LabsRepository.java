package com.example.harumag.repository;

import com.example.harumag.domain.Labs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabsRepository extends JpaRepository<Labs, String> {
}

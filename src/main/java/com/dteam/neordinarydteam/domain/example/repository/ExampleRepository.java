package com.dteam.neordinarydteam.domain.example.repository;

import com.dteam.neordinarydteam.domain.example.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Long> {}

package com.equi_management.backend.repository;

import com.equi_management.backend.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
} 
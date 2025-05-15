package com.equi_management.backend.service;

import com.equi_management.backend.model.Equipment;
import com.equi_management.backend.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(Long id, Equipment updatedEquipment) {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(id);
        if (optionalEquipment.isEmpty()) {
            throw new RuntimeException("Equipment not found");
        }
        Equipment equipment = optionalEquipment.get();
        equipment.setName(updatedEquipment.getName());
        equipment.setType(updatedEquipment.getType());
        equipment.setQuantity(updatedEquipment.getQuantity());
        equipment.setStatus(updatedEquipment.getStatus());
        equipment.setLocation(updatedEquipment.getLocation());
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }
} 
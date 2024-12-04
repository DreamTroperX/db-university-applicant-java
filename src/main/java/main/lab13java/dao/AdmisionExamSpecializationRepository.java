package main.lab13java.dao;

import main.lab13java.entities.AdmisionExamSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmisionExamSpecializationRepository extends JpaRepository<AdmisionExamSpecialization, Integer> {

    List<AdmisionExamSpecialization> findByIdSpecialization_IdOrderByIdAsc (Integer id);
}
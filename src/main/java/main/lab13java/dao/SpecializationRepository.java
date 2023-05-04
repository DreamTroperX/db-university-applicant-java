package main.lab13java.dao;

import main.lab13java.entities.Faculty;
import main.lab13java.entities.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
    List<Specialization> findByIdFaculty_IdOrderByIdAsc(Integer id);



}
package main.lab13java.dao;

import main.lab13java.entities.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {

    List<Specialization> findByIdFaculty_IdOrderByIdAsc(Integer id);

}
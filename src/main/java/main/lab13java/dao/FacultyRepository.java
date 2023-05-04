package main.lab13java.dao;

import main.lab13java.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    @Override
    Optional<Faculty> findById(Integer integer);
}
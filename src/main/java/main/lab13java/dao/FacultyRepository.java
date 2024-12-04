package main.lab13java.dao;

import main.lab13java.entities.Faculty;
import main.lab13java.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
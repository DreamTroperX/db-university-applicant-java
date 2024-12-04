package main.lab13java.dao;

import main.lab13java.entities.AdmisionExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmisionExamRepository extends JpaRepository<AdmisionExam, Integer> {
}
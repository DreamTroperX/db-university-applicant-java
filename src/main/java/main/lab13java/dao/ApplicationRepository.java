package main.lab13java.dao;

import main.lab13java.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findByIdApplicant_IdOrderByIdAsc(Integer id);

    List<Application> findByIdSpecialization_IdOrderByIdAsc(Integer id);
}
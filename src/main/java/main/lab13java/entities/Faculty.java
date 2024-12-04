package main.lab13java.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Column(name = "dean_name", nullable = false, length = 150)
    private String deanName;

    @Column(name = "number_of_students")
    private Integer numberOfStudents;

    @Column(name = "number_of_teachers")
    private Integer numberOfTeachers;

}
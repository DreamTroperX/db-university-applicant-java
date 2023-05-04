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

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "deanName", nullable = false, length = 60)
    private String deanName;

    @Column(name = "numberOfStudents", nullable = false)
    private Integer numberOfStudents;

    @Column(name = "numberOfTeachers", nullable = false)
    private Integer numberOfTeachers;

}
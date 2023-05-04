package main.lab13java.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_faculty", nullable = false)
    private Faculty idFaculty;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "number_of_students", nullable = false)
    private Integer number_of_students;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

}
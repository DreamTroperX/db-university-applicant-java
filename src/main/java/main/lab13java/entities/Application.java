package main.lab13java.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_applicant", nullable = false)
    private Applicant idApplicant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_specialization", nullable = false)
    private Specialization idSpecialization;

    @Column(name = "status", length = 150)
    private String status;

    @Column(name = "mark")
    private Integer mark;

}
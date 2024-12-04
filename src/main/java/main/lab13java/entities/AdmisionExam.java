package main.lab13java.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "admision_exam")
public class AdmisionExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "subject", nullable = false, length = 150)
    private String subject;

    @Column(name = "passing_mark", nullable = false)
    private Integer passingMark;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "adress", nullable = false, length = 150)
    private String adress;

    @Column(name = "date", nullable = false)
    private LocalDate date;

}
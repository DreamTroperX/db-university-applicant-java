package main.lab13java.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "lastname", nullable = false, length = 20)
    private String lastname;

    @Column(name = "middlename", nullable = false, length = 20)
    private String middlename;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "telephonenumber", nullable = false)
    private Integer telephonenumber;

    @Column(name = "middleZNO", nullable = false)
    private Double middleZNO;

    @Column(name = "middle_school", nullable = false)
    private Double middleSchool;



}
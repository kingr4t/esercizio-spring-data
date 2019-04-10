package it.thinkopen.restservices.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;

    @Column(name = "cf", unique = true, length = 16)
    private String fiscalCode;

    @OneToMany
    private Collection<Exam> exams;

}

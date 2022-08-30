package com.example.studentclass.Models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "class")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Class {

    @Id
    @SequenceGenerator(
            name = "class_sequence",
            sequenceName = "class_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "class_sequence"
    )
    private Long id;
    private String name;

    @OneToMany(mappedBy = "myclass")
    @ToString.Exclude
    private Set<Student> students;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Class(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}



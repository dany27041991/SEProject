package com.projectSE.credentialMicroservices.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "course_of_study")
@Entity
@AllArgsConstructor @NoArgsConstructor
public class CourseOfStudy {

    @Id
    @Column(name = "id_course_of_study")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private int id_course_of_study;

    @Column(name = "name")
    @NotEmpty @NotNull @NotBlank
    @Getter @Setter
    private String name;

    @Column(name = "description")
    @NotEmpty @NotNull @NotBlank
    @Getter @Setter
    private String description;

    public CourseOfStudy(String name, String description){
        this.name = name;
        this.description = description;
    }

}

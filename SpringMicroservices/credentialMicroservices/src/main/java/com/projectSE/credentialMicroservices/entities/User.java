package com.projectSE.credentialMicroservices.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Table(name = "user")
@Entity
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private int id_user;

    @Column(name = "name")
    @Getter @Setter
    @NotEmpty(message = "The name cannot be empty!") @NotBlank(message = "The name cannot be empty!") @NotNull(message = "The name cannot be empty!")
    private String name;

    @Column(name = "surname")
    @Getter @Setter
    @NotEmpty(message = "The surname cannot be empty!") @NotBlank(message = "The surname cannot be empty!") @NotNull(message = "The surname cannot be empty!")
    private String surname;

    @Column(name = "email")
    @Getter @Setter
    @Email
    @NotEmpty(message = "The surname cannot be empty!") @NotBlank(message = "The surname cannot be empty!") @NotNull(message = "The surname cannot be empty!")
    @Pattern(regexp=".+@.+\\.[a-z]+", message = "Invalid format of mail!")
    private String email;

    @Column(name = "password")
    @NotEmpty @NotBlank @NotNull
    @Getter @Setter
    private String password;

    @Column(name = "type")
    @Getter @Setter
    @NotNull(message = "The type cannot be empty!")
    private int type;

    @Column(name = "id_course_of_study")
    @Getter @Setter
    @NotNull(message = "The course of study cannot be empty!")
    private int id_course_of_study;

}

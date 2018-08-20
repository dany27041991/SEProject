package com.projectSE.credentialMicroservices.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "user_type")
@Entity
@AllArgsConstructor @NoArgsConstructor
public class UserType {

    @Id
    @Column(name = "id_user_type")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private int id_user_type;

    @Column(name = "name")
    @NotNull @NotBlank @NotEmpty
    @Getter @Setter
    private String name;

    public UserType(String name){
        this.name = name;
    }

}

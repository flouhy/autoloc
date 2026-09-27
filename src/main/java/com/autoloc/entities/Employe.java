package com.autoloc.entities;

import com.autoloc.enums.RoleEmploye;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {

    private Long idEmploye;
    private String nom;
    private String prenom;
    private RoleEmploye role;
}
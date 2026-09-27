package com.autoloc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    private Long idAgence;
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;
}
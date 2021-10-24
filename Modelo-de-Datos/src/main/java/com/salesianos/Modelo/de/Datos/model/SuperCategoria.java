package com.salesianos.Modelo.de.Datos.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SuperCategoria {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "superCategoria")
    private List<Categoria> categorias = new ArrayList<>();

    public SuperCategoria(String n){
        this.nombre = n;
    }



}

package com.salesianos.Modelo.de.Datos.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    @Column(name = "pvp" )
    private int pvp;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    public void addCategoria(Categoria c) {
        this.categoria = c;
        c.getProductos().add(this);
    }

    public void removeCategoria(Categoria c) {
        c.getProductos().remove(this);
        this.categoria = null;
    }

    public Producto(String n, int pvp) {
        this.nombre = n;
        this.pvp= pvp;
    }

}

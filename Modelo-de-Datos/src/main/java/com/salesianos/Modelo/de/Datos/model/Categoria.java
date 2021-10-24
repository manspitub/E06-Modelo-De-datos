package com.salesianos.Modelo.de.Datos.model;

import lombok.*;
import org.hibernate.annotations.LazyToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categoria extends SuperCategoria {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    @Builder.Default
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();

    @Builder.Default
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "super_categoria_id")
    private SuperCategoria superCategoria;

    public static class Bbuilder extends SuperCategoriaBuilder{
        Bbuilder() {
            super();
        }
    }


    public void addSuperCategoria(SuperCategoria s) {
        this.superCategoria = s;
        s.getCategorias().add(this);
    }

    public  void removeSuperCategoria(SuperCategoria s) {
        s.getCategorias().remove(this);
        this.superCategoria = null;
    }


    public Categoria(String n) {
        super();
        this.nombre = n;
    }
}

package com.salesianos.Modelo.de.Datos;

import com.salesianos.Modelo.de.Datos.model.Categoria;
import com.salesianos.Modelo.de.Datos.model.SuperCategoria;
import com.salesianos.Modelo.de.Datos.services.CategoriaService;
import com.salesianos.Modelo.de.Datos.services.ProductoService;
import com.salesianos.Modelo.de.Datos.services.SuperCategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;
    private final SuperCategoriaService superCategoriaService;

    @PostConstruct
    public void test() {




        SuperCategoria carne = SuperCategoria.builder()
                .nombre("Carne")
                .build();
        superCategoriaService.save(carne);

        Categoria categoria = Categoria.builder()
                .nombre("Embutidos")
                .superCategoria(carne)
                .build();
        categoriaService.edit(categoria);

        List<Categoria> categorias = List.of(
                Categoria.builder().nombre("Lomo").build(),
                Categoria.builder().nombre("Ternera").build()
        );

        for (int i = 0; i < categorias.size(); i++){
            categorias.get(i).addSuperCategoria(carne);
        }

        categoriaService.saveAll(categorias);

    }


}

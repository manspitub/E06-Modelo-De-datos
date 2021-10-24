package com.salesianos.Modelo.de.Datos.repositories;

import com.salesianos.Modelo.de.Datos.model.SuperCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperCategoriaRepository
        extends JpaRepository<SuperCategoria, Long> {
}

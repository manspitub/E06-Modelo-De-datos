package com.salesianos.Modelo.de.Datos.repositories;

import com.salesianos.Modelo.de.Datos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository
    extends JpaRepository<Categoria, Long> {
}

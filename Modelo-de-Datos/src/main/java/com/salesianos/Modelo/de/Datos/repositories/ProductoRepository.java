package com.salesianos.Modelo.de.Datos.repositories;

import com.salesianos.Modelo.de.Datos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

}

package com.castillo.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castillo.productos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
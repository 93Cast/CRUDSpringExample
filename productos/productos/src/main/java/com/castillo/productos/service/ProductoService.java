package com.castillo.productos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import com.castillo.productos.model.Producto;
import com.castillo.productos.repository.ProductoRepository;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Producto producto) {
        repository.save(producto);
    }

    public Producto obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
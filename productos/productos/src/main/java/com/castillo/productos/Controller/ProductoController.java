package com.castillo.productos.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.castillo.productos.model.Producto;
import com.castillo.productos.service.ProductoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", service.listarTodos());
        return "productos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {
        service.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", service.obtenerPorId(id));
        return "productos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/productos";
    }
}

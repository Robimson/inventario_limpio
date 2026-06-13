package ec.edu.uteq.inventario.controller;

import ec.edu.uteq.inventario.model.Product;
import ec.edu.uteq.inventario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("lista", productService.getAll());
        model.addAttribute("prod", new Product());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(Product p) {
        productService.save(p);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String borrar(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("prod", productService.getById(id));
        model.addAttribute("lista", productService.getAll());
        return "index";
    }
}
package ec.edu.uteq.inventario.service;

import ec.edu.uteq.inventario.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productos = new ArrayList<>();
    private Long idCounter = 1L;

    public ProductService() {
        productos.add(new Product(idCounter++, "Laptop HP", "Refactorizada", 850.0, 15));
    }

    public List<Product> getAll() { return productos; }

    public void save(Product p) {
        if (p.getId() == null) {
            p.setId(idCounter++);
            productos.add(p);
        } else {
            productos.stream()
                    .filter(item -> item.getId().equals(p.getId()))
                    .findFirst()
                    .ifPresent(item -> {
                        item.setNombre(p.getNombre());
                        item.setDescripcion(p.getDescripcion());
                        item.setPrecio(p.getPrecio());
                        item.setStock(p.getStock());
                    });
        }
    }

    public void delete(Long id) { productos.removeIf(p -> p.getId().equals(id)); }

    public Product getById(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}

package com.ministock.api;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Optional<Producto> buscarProducto(String codigo) {

        return productoRepository.findById(codigo);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public boolean añadirProducto(Producto producto) {

        if (productoRepository.existsById(producto.getCodigo())) {
            return false;
        } else {
            productoRepository.save(producto);
            return true;
        }
    }

    public boolean actualizarProducto(String codigo, Producto producto) {

        if (!codigo.equals(producto.getCodigo()))
            return false;

        if (productoRepository.existsById(codigo)) {
            productoRepository.save(producto);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarProducto(String codigo) {
        if (productoRepository.existsById(codigo)) {
            productoRepository.deleteById(codigo);
            return true;
        } else {
            return false;
        }
    }
}


package com.ministock.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Service
public class ProductoService {

    private final Map<String, Producto> productos = new HashMap<>();

    public ProductoService() {
        productos.put("P001", new Producto("P001", "Leche", 1.25, 20));
        productos.put("P002", new Producto("P002", "Pan", 0.90, 15));
        productos.put("P003", new Producto("P003", "Huevos", 2.50, 10));
    }

    public Producto buscarProducto(String codigo) {
        return productos.get(codigo);
    }

    public Collection<Producto> listarProductos() {
        return productos.values();
    }

    public boolean añadirProducto(Producto producto) {

        if (productos.containsKey(producto.getCodigo())) {
            return false;
        } else {
            productos.put(producto.getCodigo(), producto);
            return true;
        }
    }

    public boolean actualizarProducto(String codigo, Producto producto) {
        if (productos.containsKey(codigo)) {
            productos.replace(codigo, producto);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarProducto(String codigo) {
        if (productos.containsKey(codigo)) {
            productos.remove(codigo);
            return true;
        } else {
            return false;
        }
    }
}

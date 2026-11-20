package com.ministock.api;
import java.net.URI;
import java.util.Collection;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @GetMapping("/productos/{codigo}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable String codigo) {

        Producto producto = productoService.buscarProducto(codigo).orElse(null);

        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/productos")
    public Collection<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping("/productos")
    public ResponseEntity<Producto> añadirProducto(@RequestBody Producto producto) {

        if (productoService.añadirProducto(producto)) {
            return ResponseEntity.created(
                    URI.create("/productos/" + producto.getCodigo())).body(producto);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }
    }

    @PutMapping("/productos/{codigo}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable String codigo,
            @RequestBody Producto producto) {


        if (!codigo.equals(producto.getCodigo())) {
            return ResponseEntity.badRequest().build();
        }

        if (productoService.actualizarProducto(codigo, producto)) {
            return ResponseEntity.ok(producto);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/productos/{codigo}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String codigo) {

        if (productoService.eliminarProducto(codigo)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

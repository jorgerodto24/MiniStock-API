package com.ministock.api;

public class Producto {

    private final String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor
    public Producto(String codigo, String nombre, double precio, int cantidad) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (precio <= 0 || !Double.isFinite(precio)) {
            throw new IllegalArgumentException("El precio debe ser válido y mayor que cero");
        }

        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {

        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }


    public int getCantidad() {
        return cantidad;
    }


}

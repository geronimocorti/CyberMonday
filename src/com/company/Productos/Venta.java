package com.company.Productos;

import com.company.Productos.Producto;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Venta {
    private LocalDate fechaDeVenta;
    private List<Producto> productos;

    public Venta(List<Producto> productos) {
        this.productos = productos;
        fechaDeVenta = LocalDate.now();

    }

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    public Double montoTotal(){
        return productos.stream().mapToDouble(Producto::calcularCostoTotal).sum();
    }


    public boolean tieneProductoEnPromocion() {
        return productos.stream().anyMatch(Producto::estaEnPromocion);
    }

    public boolean esUnaVentaDelDia(LocalDate date){
        return date.equals(fechaDeVenta);
    }

    public Double dineroAhorrado() {
        return productos.stream().mapToDouble(Producto::dineroAhorrado).sum();
    }

    public Boolean tieneTodosLosProductosConDescuento() {
        return productos.stream().allMatch(Producto::estaEnPromocion);
    }
}

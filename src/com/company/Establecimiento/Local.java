package com.company.Establecimiento;

import com.company.Productos.Producto;
import com.company.Productos.Venta;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Local implements Establecimiento{

    List<Producto> productos = new LinkedList<>();
    List<Venta> ventas = new LinkedList<>();

    public Local(List<Producto> productos) {
        this.productos = productos;
    }

    private void addProducto(Producto producto){
        productos.add(producto);
    }

    private void remove(Producto producto){
        productos.remove(producto);
    }

    private void addProductos(List<Producto> productos){
        productos.addAll(productos);
    }

    public void addVenta(Venta venta){
        ventas.add(venta);
    }

    public Long cantidadDeVentasConAlMenosUnProductoEnPromocion(){
        return ventas.stream().filter(Venta::tieneProductoEnPromocion).count();
    }

    public Long cantidadDeVentasParaLaFecha(LocalDate dia){
        return ventas.stream().filter(venta -> venta.esUnaVentaDelDia(dia)).count();
    }

    public Double dineroAhorrado(){
        return ventas.stream().mapToDouble(Venta::dineroAhorrado).sum();
    }

    public Integer cantidadDeVentas(){
        return ventas.size();
    }

    public Double cantidadDeDineroMovido(){
        return ventas.stream().mapToDouble(Venta::montoTotal).sum();
    }

    @Override
    public Boolean conClientesTacanios() {
        return ventas.stream().allMatch(Venta::tieneTodosLosProductosConDescuento);
    }

}

package com.company;

import com.company.Establecimiento.*;
import com.company.Productos.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Material> materiales = new LinkedList<>();
        materiales.add(new Material("Madera", 100d));
        Producto camisetaDeBoca = new Indumentaria(0d, 42d, 3/5d);
        Producto celular = new Electronica(0.2d, 0.8d);
        Producto cortinas = new Decoracion(0.2d, 10d, 7d, 2d, materiales);

        Producto pantalon = new Indumentaria(0d, 45d, 8/9d);
        Producto televisor = new Electronica(0d,  0.9d);

        System.out.println("Costo de Remera: " + camisetaDeBoca.calcularCostoTotal());
        System.out.println("Costo de Celular: " + celular.calcularCostoTotal());
        System.out.println("Costo de Cortinas: " + cortinas.calcularCostoTotal());

        List<Producto> productos1 = new LinkedList<>();
        productos1.add(camisetaDeBoca);
        productos1.add(celular);
        productos1.add(cortinas);

        List<Producto> productos2 = new LinkedList<>();
        productos2.add(pantalon);
        productos2.add(televisor);

        List<Producto> todosLosProductos = new LinkedList<>();
        todosLosProductos.addAll(productos1);
        todosLosProductos.addAll(productos2);

        Local dexterShop = new Local(todosLosProductos);

        Venta venta1 = new Venta(productos1);
        Venta venta2 = new Venta(productos2);
        System.out.println("Monto Total de la venta: " + venta1.montoTotal());

        dexterShop.addVenta(venta1);
        dexterShop.addVenta(venta2);
        System.out.println("Cantidad de ventas con al menos un producto en promocion en dexter: " + dexterShop.cantidadDeVentasConAlMenosUnProductoEnPromocion());

        System.out.println("Cantidad de ventas del dia "
                + LocalDate.now() + " de dexter es: " + dexterShop.cantidadDeVentasParaLaFecha(LocalDate.now()));

        System.out.println("Cantidad de ventas del dia "
                + LocalDate.now().plusDays(1) + " de dexter es: " + dexterShop.cantidadDeVentasParaLaFecha(LocalDate.now().plusDays(1)));

        System.out.println("Dinero Ahorrado por dexter: " + dexterShop.dineroAhorrado());

        System.out.println("Cantidad de Ventas de dexter: " + dexterShop.cantidadDeVentas());

        System.out.println("Cantidad De Dinero Movido en dexter: " + dexterShop.cantidadDeDineroMovido());

        Shopping unicenter = new Shopping();
        unicenter.addLocal(dexterShop);

        System.out.println("Cantidad de dinero movido por Unicenter: " + unicenter.cantidadDeDineroMovido());

        List<Establecimiento> establecimientosDeLaEmpresa = new LinkedList<>();
        establecimientosDeLaEmpresa.add(unicenter);
        establecimientosDeLaEmpresa.add(dexterShop);

        Lugar capitalFederal = new Lugar("Capital Federal", establecimientosDeLaEmpresa);

        List<Lugar> lugares = new LinkedList<>();
        lugares.add(capitalFederal);

        Empresa empresa = new Empresa(establecimientosDeLaEmpresa, lugares);
        System.out.println("Lugar con mayor ventas: " + empresa.lugarConMasVentas().toString());

    }
}

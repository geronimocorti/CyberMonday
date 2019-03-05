package com.company.Productos;

public class Indumentaria extends Producto{

    private Double talle;
    private Double factorDeConversion;

    public Indumentaria(Double descuento, Double talle, Double factorDeConversion) {
        super(descuento);
        this.talle = talle;
        this.factorDeConversion = factorDeConversion;
    }

    @Override
    protected Double calcularCostoProducto() {
        return talle * factorDeConversion;
    }
}

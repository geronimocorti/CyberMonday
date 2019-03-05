package com.company.Productos;

public class Electronica extends Producto{

    private static final Double COSTO_CONSTANTE = 15d;
    private static Double factorDeConversion;

    public Electronica(Double descuento, Double factorDeConversion) {
        super(descuento);
        this.factorDeConversion = factorDeConversion;
    }

    @Override
    protected Double calcularCostoProducto() {
        return COSTO_CONSTANTE * factorDeConversion;
    }

    public static Double getFactorDeConversion() {
        return factorDeConversion;
    }

    public static void setFactorDeConversion(Double factorDeConversion) {
        Electronica.factorDeConversion = factorDeConversion;
    }


}

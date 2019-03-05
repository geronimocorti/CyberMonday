package com.company.Productos;

import com.company.Exceptions.PorcentajeDescuentoInvalidoException;

abstract public class Producto {

    private Double descuento;

    public Producto(Double descuento){
        if(descuento < 0 && descuento > 0.7){
            throw new PorcentajeDescuentoInvalidoException("El descuento tiene que estar entre 0 y 0.7");
        }
        this.descuento = descuento;
    }

    public Double calcularCostoTotal(){
        return calcularCostoProducto() * (1 + calcularDescuento());
    }

    private Double calcularDescuento() {
        return (estaEnPromocion())? descuento : 1;
    }

    protected abstract Double calcularCostoProducto();


    public boolean estaEnPromocion()
    {
        return descuento > 0;
    }

    public Double dineroAhorrado() {
        return (estaEnPromocion())? descuento * calcularCostoProducto() : 0;
    }
}

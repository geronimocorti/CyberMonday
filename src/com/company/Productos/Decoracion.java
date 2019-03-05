package com.company.Productos;

import com.company.Exceptions.SinMaterialesException;

import java.util.List;

public class Decoracion extends Producto {
    private List<Material> materiales;
    private Double peso;
    private Double largo;
    private Double alto;

    public Decoracion(Double descuento, Double peso, Double largo, Double alto, List<Material> materiales) {
        super(descuento);
        if(materiales.size() < 1){
            throw new SinMaterialesException("El producto tiene que tener al menos un material.");
        }
        this.materiales = materiales;
        this.peso = peso;
        this.largo = largo;
        this.alto = alto;


    }

    @Override
    protected Double calcularCostoProducto() {
        return coeficientePrenda() + coeficienteMateriales();
    }

    private Double coeficienteMateriales() {
        return materiales.stream().mapToDouble(Material::getCosto).sum();
    }

    private Double coeficientePrenda() {
        return peso * largo * alto;
    }

    private void addMaterial(Material material){
        materiales.add(material);
    }

    private void removeMaterial(Material material){
        materiales.remove(material);
    }
}

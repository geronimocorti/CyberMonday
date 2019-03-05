package com.company.Establecimiento;

import java.util.LinkedList;
import java.util.List;

public class Lugar {
    private String nombre;
    private List<Establecimiento> establecimientos = new LinkedList<>();

    public Lugar(String nombre, List<Establecimiento> establecimientos) {
        this.nombre = nombre;
        this.establecimientos = establecimientos;
    }

    public void addEstablecimiento(Establecimiento establecimiento){
        establecimientos.add(establecimiento);
    }

    public void removeEstablecimiento(Establecimiento establecimiento){
        establecimientos.remove(establecimiento);
    }

    public Integer cantidadDeVentas(){
        return establecimientos.stream().mapToInt(Establecimiento::cantidadDeVentas).sum();
    }

    public Boolean conClientesTacanios() {
        return establecimientos.stream().allMatch(Establecimiento::conClientesTacanios);
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}

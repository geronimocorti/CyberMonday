package com.company.Establecimiento;

import java.util.Comparator;
import java.util.List;

public class Empresa {
    public List<Establecimiento> establecimientosDeLaEmpresa;
    public List<Lugar> lugares;

    public Empresa(List<Establecimiento> establecimientosDeLaEmpresa, List<Lugar> lugares) {
        this.establecimientosDeLaEmpresa = establecimientosDeLaEmpresa;
        this.lugares = lugares;
    }

    public Lugar lugarConMasVentas(){
        return lugares.stream().max(Comparator.comparing(Lugar::cantidadDeVentas)).orElse(null);
    }

    public boolean algunoTieneClientesTacanios(){
        return lugares.stream().anyMatch(Lugar::conClientesTacanios);
    }

}

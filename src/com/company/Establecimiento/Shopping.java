package com.company.Establecimiento;

import java.util.LinkedList;
import java.util.List;

public class Shopping implements Establecimiento{
    List<Local> locales = new LinkedList<>();

    public void addLocal(Local local){
        locales.add(local);
    }

    public void removeLocal(Local local){
        locales.remove(local);
    }

    @Override
    public Integer cantidadDeVentas(){
        return locales.stream().mapToInt(Local::cantidadDeVentas).sum();
    }

    @Override
    public Double cantidadDeDineroMovido(){
        return locales.stream().mapToDouble(Local::cantidadDeDineroMovido).sum();
    }

    @Override
    public Boolean conClientesTacanios() {
        return locales.stream().allMatch(Local::conClientesTacanios);
    }

}

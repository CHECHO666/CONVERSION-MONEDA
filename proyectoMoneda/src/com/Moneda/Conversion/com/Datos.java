package com.Moneda.Conversion.com;

import java.util.ArrayList;
import java.util.List;

public class Datos {

    private String DivisiaConvertir;

    private String DivisaAconvertir;

    private double cantidaConvertir;
    private List historialBusqueda = new ArrayList<>();

    private List divisasDisponible = new ArrayList<>();



    public List getDivisasDisponible() {
        return divisasDisponible;
    }

    public void setDivisasDisponible(List divisasDisponible) {
        this.divisasDisponible = divisasDisponible;
    }

    public void agregarDivisasDisponible (String divisasDisponiblescode) {
        divisasDisponible.add(divisasDisponiblescode);
    }

    public void agregarResumenBusqueda(String resumen) {
        historialBusqueda.add(resumen);
    }
    public List getHistorialBusqueda() {
        return historialBusqueda;
    }

    public void setHistorialBusqueda(List historialBusqueda) {
        this.historialBusqueda = historialBusqueda;
    }

    public Datos(String _divisiaConvertir, String _divisaAconvertir, double _cantidaConvertir) {
        this.DivisiaConvertir = _divisiaConvertir;
        this.DivisaAconvertir = _divisaAconvertir;
        this.cantidaConvertir = _cantidaConvertir;
    }

    public Datos() {

    }

    public String getDivisiaConvertir() {
        return DivisiaConvertir;
    }

    public void setDivisiaConvertir(String divisiaConvertir) {
        DivisiaConvertir = divisiaConvertir;
    }

    public String getDivisaAconvertir() {
        return DivisaAconvertir;
    }

    public void setDivisaAconvertir(String divisaAconvertir) {
        DivisaAconvertir = divisaAconvertir;
    }

    public double getCantidaConvertir() {
        return cantidaConvertir;
    }

    public void setCantidaConvertir(double cantidaConvertir) {
        this.cantidaConvertir = cantidaConvertir;
    }
}
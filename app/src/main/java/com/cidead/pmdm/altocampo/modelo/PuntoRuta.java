package com.cidead.pmdm.altocampo.modelo;

import java.math.BigDecimal;

public class PuntoRuta {
    private Ruta ruta_id;
    private int tramo;
    private int orden;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private int altitud;
    public PuntoRuta(){}
    public PuntoRuta(Ruta ruta_id, int tramo, int orden, BigDecimal latitud, BigDecimal longitud, int altitud) {
        this.ruta_id = ruta_id;
        this.tramo = tramo;
        this.orden = orden;
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitud = altitud;
    }

    public Ruta getRuta_id() {
        return ruta_id;
    }
    public int getTramo() {
        return tramo;
    }

    public void setTramo(int tramo) {
        this.tramo = tramo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    @Override
    public String toString() {
        return "PuntoRuta{" +
                "ruta_id=" + ruta_id +
                ", tramo=" + tramo +
                ", orden=" + orden +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", altitud=" + altitud +
                '}';
    }
}
package com.cidead.pmdm.altocampo.modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

public class Contenido {
    private int id;
    private String tipo;
    private String titulo_es;
    private String titulo_en;
    private String entidad_nombre;
    private String contacto_url;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private Date inicio;
    private Date fin;
    private String accesibilidad_es;
    private String accesibilidad_en;
    private String verificacion;
    private LocalDateTime revisado_at;
    private String fuente_url;
    private String estado;
    public Contenido(){}

    public Contenido(int id, String tipo, String titulo_es, String titulo_en, String entidad_nombre, String contacto_url, BigDecimal latitud, BigDecimal longitud, Date inicio, Date fin, String accesibilidad_es, String accesibilidad_en, String verificacion, LocalDateTime revisado_at, String fuente_url, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.titulo_es = titulo_es;
        this.titulo_en = titulo_en;
        this.entidad_nombre = entidad_nombre;
        this.contacto_url = contacto_url;
        this.latitud = latitud;
        this.longitud = longitud;
        this.inicio = inicio;
        this.fin = fin;
        this.accesibilidad_es = accesibilidad_es;
        this.accesibilidad_en = accesibilidad_en;
        this.verificacion = verificacion;
        this.revisado_at = revisado_at;
        this.fuente_url = fuente_url;
        this.estado = estado;
    }
    public Contenido(String tipo, String titulo_es, String titulo_en, String entidad_nombre, String contacto_url, BigDecimal latitud, BigDecimal longitud, Date inicio, Date fin, String accesibilidad_es, String accesibilidad_en, String verificacion, LocalDateTime revisado_at, String fuente_url, String estado) {
        this.tipo = tipo;
        this.titulo_es = titulo_es;
        this.titulo_en = titulo_en;
        this.entidad_nombre = entidad_nombre;
        this.contacto_url = contacto_url;
        this.latitud = latitud;
        this.longitud = longitud;
        this.inicio = inicio;
        this.fin = fin;
        this.accesibilidad_es = accesibilidad_es;
        this.accesibilidad_en = accesibilidad_en;
        this.verificacion = verificacion;
        this.revisado_at = revisado_at;
        this.fuente_url = fuente_url;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo_es() {
        return titulo_es;
    }

    public void setTitulo_es(String titulo_es) {
        this.titulo_es = titulo_es;
    }

    public String getTitulo_en() {
        return titulo_en;
    }

    public void setTitulo_en(String titulo_en) {
        this.titulo_en = titulo_en;
    }

    public String getEntidad_nombre() {
        return entidad_nombre;
    }

    public void setEntidad_nombre(String entidad_nombre) {
        this.entidad_nombre = entidad_nombre;
    }

    public String getContacto_url() {
        return contacto_url;
    }

    public void setContacto_url(String contacto_url) {
        this.contacto_url = contacto_url;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getAccesibilidad_es() {
        return accesibilidad_es;
    }

    public void setAccesibilidad_es(String accesibilidad_es) {
        this.accesibilidad_es = accesibilidad_es;
    }

    public String getAccesibilidad_en() {
        return accesibilidad_en;
    }

    public void setAccesibilidad_en(String accesibilidad_en) {
        this.accesibilidad_en = accesibilidad_en;
    }

    public String getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(String verificacion) {
        this.verificacion = verificacion;
    }

    public LocalDateTime getRevisado_at() {
        return revisado_at;
    }

    public void setRevisado_at(LocalDateTime revisado_at) {
        this.revisado_at = revisado_at;
    }

    public String getFuente_url() {
        return fuente_url;
    }

    public void setFuente_url(String fuente_url) {
        this.fuente_url = fuente_url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Contenido{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", titulo_es='" + titulo_es + '\'' +
                ", titulo_en='" + titulo_en + '\'' +
                ", entidad_nombre='" + entidad_nombre + '\'' +
                ", contacto_url='" + contacto_url + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", accesibilidad_es='" + accesibilidad_es + '\'' +
                ", accesibilidad_en='" + accesibilidad_en + '\'' +
                ", verificacion='" + verificacion + '\'' +
                ", revisado_at=" + revisado_at +
                ", fuente_url='" + fuente_url + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
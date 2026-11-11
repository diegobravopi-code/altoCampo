package com.cidead.pmdm.altocampo.modelo;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Ruta {
    private int id;
    private String titulo_es;
    private String titulo_en;
    private String descripcion_es;
    private String descripcion_en;
    private Contenido[] contenidos;
    private BigDecimal distancia_km;
    private int desnivel_m;
    private String dificultad;
    private String temporada;
    private String gpx_url;
    private String origen_url;
    private String autor;
    private String accesibilidad_es;
    private String accesibilidad_en;
    private String verificacion;
    private LocalDateTime revisado_at;
    private String estado;
    public Ruta(){}

    public Ruta(int id, String titulo_es, String titulo_en, String descripcion_es, String descripcion_en, Contenido[] contenidos, BigDecimal distancia_km, int desnivel_m, String dificultad, String temporada, String gpx_url, String origen_url, String autor, String accesibilidad_es, String accesibilidad_en, String verificacion, LocalDateTime revisado_at, String estado) {
        this.id = id;
        this.titulo_es = titulo_es;
        this.titulo_en = titulo_en;
        this.descripcion_es = descripcion_es;
        this.descripcion_en = descripcion_en;
        this.contenidos = contenidos;
        this.distancia_km = distancia_km;
        this.desnivel_m = desnivel_m;
        this.dificultad = dificultad;
        this.temporada = temporada;
        this.gpx_url = gpx_url;
        this.origen_url = origen_url;
        this.autor = autor;
        this.accesibilidad_es = accesibilidad_es;
        this.accesibilidad_en = accesibilidad_en;
        this.verificacion = verificacion;
        this.revisado_at = revisado_at;
        this.estado = estado;
    }
    public Ruta(String titulo_es, String titulo_en, String descripcion_es, String descripcion_en, Contenido[] contenidos, BigDecimal distancia_km, int desnivel_m, String dificultad, String temporada, String gpx_url, String origen_url, String autor, String accesibilidad_es, String accesibilidad_en, String verificacion, LocalDateTime revisado_at, String estado) {
        this.titulo_es = titulo_es;
        this.titulo_en = titulo_en;
        this.descripcion_es = descripcion_es;
        this.descripcion_en = descripcion_en;
        this.contenidos = contenidos;
        this.distancia_km = distancia_km;
        this.desnivel_m = desnivel_m;
        this.dificultad = dificultad;
        this.temporada = temporada;
        this.gpx_url = gpx_url;
        this.origen_url = origen_url;
        this.autor = autor;
        this.accesibilidad_es = accesibilidad_es;
        this.accesibilidad_en = accesibilidad_en;
        this.verificacion = verificacion;
        this.revisado_at = revisado_at;
        this.estado = estado;
    }

    public int getId() {
        return id;
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

    public String getDescripcion_es() {
        return descripcion_es;
    }

    public void setDescripcion_es(String descripcion_es) {
        this.descripcion_es = descripcion_es;
    }

    public String getDescripcion_en() {
        return descripcion_en;
    }

    public void setDescripcion_en(String descripcion_en) {
        this.descripcion_en = descripcion_en;
    }

    public Contenido[] getContenidos() {
        return contenidos;
    }

    public void setContenidos(Contenido[] contenidos) {
        this.contenidos = contenidos;
    }

    public BigDecimal getDistancia_km() {
        return distancia_km;
    }

    public void setDistancia_km(BigDecimal distancia_km) {
        this.distancia_km = distancia_km;
    }

    public int getDesnivel_m() {
        return desnivel_m;
    }

    public void setDesnivel_m(int desnivel_m) {
        this.desnivel_m = desnivel_m;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getGpx_url() {
        return gpx_url;
    }

    public void setGpx_url(String gpx_url) {
        this.gpx_url = gpx_url;
    }

    public String getOrigen_url() {
        return origen_url;
    }

    public void setOrigen_url(String origen_url) {
        this.origen_url = origen_url;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "id=" + id +
                ", titulo_es='" + titulo_es + '\'' +
                ", titulo_en='" + titulo_en + '\'' +
                ", descripcion_es='" + descripcion_es + '\'' +
                ", descripcion_en='" + descripcion_en + '\'' +
                ", contenidos=" + Arrays.toString(contenidos) +
                ", distancia_km=" + distancia_km +
                ", desnivel_m=" + desnivel_m +
                ", dificultad='" + dificultad + '\'' +
                ", temporada='" + temporada + '\'' +
                ", gpx_url='" + gpx_url + '\'' +
                ", origen_url='" + origen_url + '\'' +
                ", autor='" + autor + '\'' +
                ", accesibilidad_es='" + accesibilidad_es + '\'' +
                ", accesibilidad_en='" + accesibilidad_en + '\'' +
                ", verificacion='" + verificacion + '\'' +
                ", revisado_at=" + revisado_at +
                ", estado='" + estado + '\'' +
                '}';
    }
}
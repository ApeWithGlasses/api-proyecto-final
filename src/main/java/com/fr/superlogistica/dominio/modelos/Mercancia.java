package com.fr.superlogistica.dominio.modelos;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mercancias")
public class Mercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "codigoIUP")
    private String codigoIUP;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaEntrada")
    private LocalDate fechaEntrada;

    @Column(name = "motivoDevolucion")
    private String motivoDevolucion;

    @Column(name = "volumen")
    private Integer volumen;

    @Column(name = "enBodega")
    private Boolean enBodega;

    @ManyToOne
    @JoinColumn(name = "id_zona")
    private Zona zona;

    @OneToMany(mappedBy = "mercancias")
    private List<Movimientos> movimientos;

    public Mercancia() {
    }

    public Mercancia(Integer id, String codigoIUP, String nombre, String descripcion, LocalDate fechaEntrada, String motivoDevolucion, Integer volumen, Boolean enBodega, Zona zona, List<Movimientos> movimientos) {
        this.id = id;
        this.codigoIUP = codigoIUP;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrada = fechaEntrada;
        this.motivoDevolucion = motivoDevolucion;
        this.volumen = volumen;
        this.enBodega = enBodega;
        this.zona = zona;
        this.movimientos = movimientos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoIUP() {
        return codigoIUP;
    }

    public void setCodigoIUP(String codigoIUP) {
        this.codigoIUP = codigoIUP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public Boolean isEnBodega() {
        return enBodega;
    }

    public void setEnBodega(Boolean enBodega) {
        this.enBodega = enBodega;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public List<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }
}

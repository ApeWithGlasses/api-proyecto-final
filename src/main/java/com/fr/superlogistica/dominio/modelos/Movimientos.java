package com.fr.superlogistica.dominio.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "movimientos")
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo_movimiento")
    private String tipoMovimineto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_mercancia")
    private Mercancia mercancias;

    public Movimientos() {
    }

    public Movimientos(Integer id, String tipoMovimineto, LocalDate fecha, Mercancia mercancias) {
        this.id = id;
        this.tipoMovimineto = tipoMovimineto;
        this.fecha = fecha;
        this.mercancias = mercancias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMovimineto() {
        return tipoMovimineto;
    }

    public void setTipoMovimineto(String tipoMovimineto) {
        this.tipoMovimineto = tipoMovimineto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Mercancia getMercancias() {
        return mercancias;
    }

    public void setMercancias(Mercancia mercancias) {
        this.mercancias = mercancias;
    }
}

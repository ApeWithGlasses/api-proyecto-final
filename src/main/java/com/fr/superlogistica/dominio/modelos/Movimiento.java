package com.fr.superlogistica.dominio.modelos;

import javax.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "id_mercancia")
    private Integer idMercancia;

    @ManyToOne
    @JoinColumn(name = "id_mercancia", insertable = false, updatable = false)
    private Mercancia mercancias;

    public Movimiento() {
    }

    public Movimiento(Integer id, String tipoMovimineto, LocalDate fecha, Mercancia mercancias) {
        this.id = id;
        this.tipoMovimiento = tipoMovimineto;
        this.fecha = fecha;
        this.mercancias = mercancias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
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

    public Integer getIdMercancia() {
        return idMercancia;
    }

    public void setIdMercancia(Integer idMercancia) {
        this.idMercancia = idMercancia;
    }
}

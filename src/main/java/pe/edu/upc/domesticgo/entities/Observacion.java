package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Observacion")
public class Observacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObservacion;

    @Column(name = "fechaObservacion", nullable = false)
    private LocalDate fechaObservacion;

    @Column(name = "detalleObservacion", nullable = false,length = 250)
    private String detalleObservacion;

    // Foreing Keys @ManytoOne Usuario y Servicio

    @ManyToOne
    @JoinColumn(name = "idUsuario",nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idServicio",nullable = false)
    private Servicio servicio;

    // Constructores, Getters and Setters (falta constructores completo y llave foranea)

    public Observacion() {
    }

    public Observacion(int idObservacion, LocalDate fechaObservacion, String detalleObservacion, Usuario usuario, Servicio servicio) {
        this.idObservacion = idObservacion;
        this.fechaObservacion = fechaObservacion;
        this.detalleObservacion = detalleObservacion;
        this.usuario = usuario;
        this.servicio = servicio;
    }

    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    public LocalDate getFechaObservacion() {
        return fechaObservacion;
    }

    public void setFechaObservacion(LocalDate fechaObservacion) {
        this.fechaObservacion = fechaObservacion;
    }

    public String getDetalleObservacion() {
        return detalleObservacion;
    }

    public void setDetalleObservacion(String detalleObservacion) {
        this.detalleObservacion = detalleObservacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}

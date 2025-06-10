package pe.edu.upc.domesticgo.dtos;

import pe.edu.upc.domesticgo.entities.Servicio;
import pe.edu.upc.domesticgo.entities.Usuario;

import java.time.LocalDate;

public class ObservacionDTO {
    private int idObservacion;
    private LocalDate fechaObservacion;
    private String detalleObservacion;
    private Usuario usuario;
    private Servicio servicio;

    // Getters and Setters
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

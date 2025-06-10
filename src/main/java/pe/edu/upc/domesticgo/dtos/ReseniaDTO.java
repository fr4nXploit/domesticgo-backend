package pe.edu.upc.domesticgo.dtos;

import pe.edu.upc.domesticgo.entities.Servicio;
import pe.edu.upc.domesticgo.entities.Usuario;

import java.time.LocalDate;

public class ReseniaDTO {
    private int idResenia;
    private LocalDate fechaResenia;
    private String detalleResenia;
    private Usuario usuario;
    private Servicio servicio;

    // Getters and Setters
    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public LocalDate getFechaResenia() {
        return fechaResenia;
    }

    public void setFechaResenia(LocalDate fechaResenia) {
        this.fechaResenia = fechaResenia;
    }

    public String getDetalleResenia() {
        return detalleResenia;
    }

    public void setDetalleResenia(String detalleResenia) {
        this.detalleResenia = detalleResenia;
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

package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    @Column(name = "fechaNotificacion", nullable = false)
    private LocalDate fechaNotificacion;

    @Column(name = "detalleNotificacion", nullable = false, length = 150)
    private String detalleNotificacion;

    //Foreign Key idUsuario @ManytoOne

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;


    // Constructores, Getters and Setters (falta constructores completo y llave foranea)

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, LocalDate fechaNotificacion, String detalleNotificacion, Usuario usuario) {
        this.idNotificacion = idNotificacion;
        this.fechaNotificacion = fechaNotificacion;
        this.detalleNotificacion = detalleNotificacion;
        this.usuario = usuario;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public LocalDate getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(LocalDate fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getDetalleNotificacion() {
        return detalleNotificacion;
    }

    public void setDetalleNotificacion(String detalleNotificacion) {
        this.detalleNotificacion = detalleNotificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

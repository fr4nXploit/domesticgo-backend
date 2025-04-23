package pe.edu.upc.domesticgo.dtos;
import java.time.LocalDate;

public class NotificacionDTO {
    private int idNotificacion;
    private LocalDate fechaNotificacion;
    private String detalleNotificacion;
    // Falta Foreign Key de Usuario


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
}

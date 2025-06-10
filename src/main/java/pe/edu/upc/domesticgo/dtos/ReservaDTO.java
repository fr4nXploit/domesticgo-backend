package pe.edu.upc.domesticgo.dtos;

import java.time.LocalDate;

public class ReservaDTO {
    private int idReserva;
    private LocalDate fechaReserva;
    private String detalleReserva;

    // Getters and Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(String detalleReserva) {
        this.detalleReserva = detalleReserva;
    }
}

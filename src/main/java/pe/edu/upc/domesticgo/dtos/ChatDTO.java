package pe.edu.upc.domesticgo.dtos;
import java.time.LocalDate;

public class ChatDTO {
    private int idChat;
    private LocalDate fechaMensaje;
    private String detalleMensaje;
    // Falta Foreign Key Usuario


    // Getters and Setters
    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public LocalDate getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDate fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public String getDetalleMensaje() {
        return detalleMensaje;
    }

    public void setDetalleMensaje(String detalleMensaje) {
        this.detalleMensaje = detalleMensaje;
    }
}

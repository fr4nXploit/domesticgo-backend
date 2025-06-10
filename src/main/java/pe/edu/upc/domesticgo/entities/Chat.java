package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChat;

    @Column(name = "fechaMensaje", nullable = false)
    private LocalDate fechaMensaje;

    @Column(name = "detalleMensaje", nullable = false, length = 150)
    private String detalleMensaje;

    // Foreign Keys  idContratante (Usuario) e idContratado (Usuario) ambas @ManytoOne

    @ManyToOne
    @JoinColumn(name = "idContratante", nullable = false)
    private Usuario contratante;

    @ManyToOne
    @JoinColumn(name = "idContratado", nullable = false)
    private Usuario contratado;

    // Getters and Setters and Constructors (falta constructores completo y llave foranea)

    public Chat() {
    }

    public Chat(int idChat, LocalDate fechaMensaje, String detalleMensaje, Usuario contratante, Usuario contratado) {
        this.idChat = idChat;
        this.fechaMensaje = fechaMensaje;
        this.detalleMensaje = detalleMensaje;
        this.contratante = contratante;
        this.contratado = contratado;
    }

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

    public Usuario getContratante() {
        return contratante;
    }

    public void setContratante(Usuario contratante) {
        this.contratante = contratante;
    }

    public Usuario getContratado() {
        return contratado;
    }

    public void setContratado(Usuario contratado) {
        this.contratado = contratado;
    }
}

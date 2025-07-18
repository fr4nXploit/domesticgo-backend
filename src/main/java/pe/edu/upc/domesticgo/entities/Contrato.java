package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrato;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaFinal", nullable = false)
    private LocalDate fechaFinal;

    @Column(name = "archivo", nullable = false, length = 150)
    private String archivo;

    @Column(name = "descripcionContrato", nullable = false, length = 150)
    private String descripcionContrato;

    // Foreign Keys @ManytoOne Usuario contratante y contratado, @OnetoOne Ubicacion

    @ManyToOne
    @JoinColumn(name = "idContratante", nullable = false)
    private Usuario contratante;

    @ManyToOne
    @JoinColumn(name = "idContratado", nullable = false)
    private Usuario contratado;

    // Verificar si funciona el @OnetoOne sino utiliza @OnetoMany
    @OneToOne
    @JoinColumn(name = "idUbicacion", nullable = false)
    private Ubicacion ubicacion;

    // Constructores, Getters and Setters (falta constructores completo y llave foranea)


    public Contrato() {
    }

    public Contrato(int idContrato, LocalDate fechaInicio, LocalDate fechaFinal, String archivo, String descripcionContrato, Usuario contratante, Usuario contratado, Ubicacion ubicacion) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.archivo = archivo;
        this.descripcionContrato = descripcionContrato;
        this.contratante = contratante;
        this.contratado = contratado;
        this.ubicacion = ubicacion;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getDescripcionContrato() {
        return descripcionContrato;
    }

    public void setDescripcionContrato(String descripcionContrato) {
        this.descripcionContrato = descripcionContrato;
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

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}

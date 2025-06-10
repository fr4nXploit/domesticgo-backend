package pe.edu.upc.domesticgo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "PruebaCliente")
public class PruebaCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPCliente;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "fecha_nacimiento", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;

    @Column(name = "hora_salida", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horaSalida;

    @Column(name = "sueldo", nullable = false)
    private double sueldo;

    @Column(name = "experto", nullable = false)
    private boolean experto;

    @ManyToOne
    @JoinColumn(name = "idRol",nullable = false)
    private Rol rol;

    // G y S

    public PruebaCliente() {
    }

    public PruebaCliente(int idPCliente, String nombre, String apellido, int edad, LocalDate fechaNacimiento, LocalTime horaSalida, double sueldo,boolean experto, Rol rol) {
        this.idPCliente = idPCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.horaSalida = horaSalida;
        this.sueldo = sueldo;
        this.experto = true;
        this.rol = rol;
    }

    public int getIdPCliente() {
        return idPCliente;
    }

    public void setIdPCliente(int idPCliente) {
        this.idPCliente = idPCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isExperto() {
        return experto;
    }

    public void setExperto(boolean experto) {
        this.experto = experto;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

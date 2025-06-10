package pe.edu.upc.domesticgo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import pe.edu.upc.domesticgo.entities.Rol;

import java.time.LocalDate;
import java.time.LocalTime;

public class PruebaClienteDTO {
    private int idPCliente;
    private String nombre;
    private String apellido;
    private int edad;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;
    private LocalTime horaSalida;
    private double sueldo;
    private boolean experto;
    private Rol rol;

    // G y S

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

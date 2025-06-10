package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
// Genesis le pudo extends DTO a public class Rol, porque?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nombreRol", nullable = false, length = 25)
    private String nombreRol;


    // Constructores, Getters and Setters

    public Rol() {
    }

    public Rol(int idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}

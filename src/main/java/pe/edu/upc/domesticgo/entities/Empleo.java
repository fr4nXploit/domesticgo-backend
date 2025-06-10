package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleo")
public class Empleo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleo;

    @Column(name = "nombreEmpleo", nullable = false, length = 50)
    private String nombreEmpleo;

    // Constructores, Getters and Setters

    public Empleo() {}

    public Empleo(int idEmpleo, String nombreEmpleo) {
        this.idEmpleo = idEmpleo;
        this.nombreEmpleo = nombreEmpleo;
    }

    public int getIdEmpleo() {
        return idEmpleo;
    }

    public void setIdEmpleo(int idEmpleo) {
        this.idEmpleo = idEmpleo;
    }

    public String getNombreEmpleo() {
        return nombreEmpleo;
    }

    public void setNombreEmpleo(String nombreEmpleo) {
        this.nombreEmpleo = nombreEmpleo;
    }
}

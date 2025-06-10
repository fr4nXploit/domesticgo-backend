package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUbicacion;

    @Column(name = "direccion", nullable = false, length = 250)
    private String direccion;

    @Column(name = "latitud", nullable = false, length = 50)
    private String latitud;

    @Column(name = "longitud", nullable = false, length = 50)
    private String longitud;

    @Column(name = "enlaceUbicacion", nullable = false, length = 250)
    private String enlaceUbicacion;

    // Constructores, Getters and Setters (falta constructores completo y llave foranea)

    public Ubicacion() {
    }

    public Ubicacion(int idUbicacion, String direccion, String latitud, String longitud, String enlaceUbicacion) {
        this.idUbicacion = idUbicacion;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.enlaceUbicacion = enlaceUbicacion;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getEnlaceUbicacion() {
        return enlaceUbicacion;
    }

    public void setEnlaceUbicacion(String enlaceUbicacion) {
        this.enlaceUbicacion = enlaceUbicacion;
    }
}

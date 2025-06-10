package pe.edu.upc.domesticgo.dtos;

public class UbicacionDTO {
    private int idUbicacion;
    private String direccion;
    private String latitud;
    private String longitud;
    private String enlaceUbicacion;

    // Getters and Setters
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

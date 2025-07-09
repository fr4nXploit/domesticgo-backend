package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = true, length = 50)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = true, length = 50)
    private String apellidoMaterno;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "foto", nullable = true, length = 255)
    private String foto;


    // Foreign Key @ManytoOne Rol y Empleo


    @OneToOne
    @JoinColumn(name = "idEmpleo", nullable = false)
    private Empleo empleo;  // Relación con Empleo


    // Constructores, Getters y Setters

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, String email, String foto, Empleo empleo) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.foto = foto;
        this.empleo = empleo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    

    public Empleo getEmpleo() {
        return empleo;
    }

    public void setEmpleo(Empleo empleo) {
        this.empleo = empleo;
    }
}

package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    // Metodos de CRUD
    public List<Usuario> list();
    public void insert(Usuario user);
    public void update(Usuario user);
    public void delete(int id);
    public Usuario searchId(int id);

}

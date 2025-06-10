package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Rol;

import java.util.List;

public interface IRolService {
    // Metodos de CRUD
    public List<Rol> list();
    public void insert(Rol user);
    public void update(Rol user);
    public void delete(int id);
    public Rol searchId(int id);
}

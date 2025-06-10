package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.PruebaCliente;

import java.util.List;

public interface IPruebaClienteService {
    // Metodos de CRUD
    public List<PruebaCliente> list();
    public void insert(PruebaCliente user);
    public void update(PruebaCliente user);
    public void delete(int id);
    public PruebaCliente searchId(int id);
}

package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Observacion;

import java.util.List;

public interface IObservacionService {
    // Metodos de CRUD
    public List<Observacion> list();
    public void insert(Observacion user);
    public void update(Observacion user);
    public void delete(int id);
    public Observacion searchId(int id);
}

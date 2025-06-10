package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Reserva;

import java.util.List;

public interface IReservaService {
    // Metodos de CRUD
    public List<Reserva> list();
    public void insert(Reserva user);
    public void update(Reserva user);
    public void delete(int id);
    public Reserva searchId(int id);
}

package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.dtos.ServiciosPendientesDTO;
import pe.edu.upc.domesticgo.dtos.IngresosPorServicioDTO;
import pe.edu.upc.domesticgo.entities.Servicio;

import java.util.List;

public interface IServicioService {
    // Metodos de CRUD
    public List<Servicio> list();
    public void insert(Servicio user);
    public void update(Servicio user);
    public void delete(int id);
    public Servicio searchId(int id);

    // Queries personalizadas
    public ServiciosPendientesDTO obtenerServiciosPendientes();
    public List<IngresosPorServicioDTO> obtenerIngresosPorServicio();
}

package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.dtos.ServiciosPendientesDTO;
import pe.edu.upc.domesticgo.dtos.IngresosPorServicioDTO;
import pe.edu.upc.domesticgo.entities.Servicio;
import pe.edu.upc.domesticgo.repositories.IServicioRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IServicioService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioServiceImplement implements IServicioService {
    @Autowired
    private IServicioRepository serRepository;

    // Implementacion de Metodos CRUD
    @Override
    public List<Servicio> list() {
        return serRepository.findAll();
    }

    @Override
    public void insert(Servicio serv) {
        serRepository.save(serv);
    }

    @Override
    public void update(Servicio serv) {
        serRepository.save(serv);
    }

    @Override
    public void delete(int id) {
        serRepository.deleteById(id);
    }

    @Override
    public Servicio searchId(int id) {
        return serRepository.findById(id).orElse(new Servicio());
    }

    // Implementación de queries personalizadas
    @Override
    public ServiciosPendientesDTO obtenerServiciosPendientes() {
        Long total = serRepository.contarServiciosPendientes();
        return new ServiciosPendientesDTO(total != null ? total : 0L);
    }

    @Override
    public List<IngresosPorServicioDTO> obtenerIngresosPorServicio() {
        List<Object[]> results = serRepository.calcularIngresosPorTipoServicio();
        List<IngresosPorServicioDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            IngresosPorServicioDTO dto = new IngresosPorServicioDTO();
            dto.setTipoServicio((String) result[0]);
            dto.setTotalIngresos((Double) result[1]);
            dtos.add(dto);
        }

        return dtos;
    }
}

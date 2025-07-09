package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.dtos.ReseniasPorTrabajadorDTO;
import pe.edu.upc.domesticgo.entities.Resenia;
import pe.edu.upc.domesticgo.repositories.IReseniaRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IReseniaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReseniaServiceImplement implements IReseniaService {
    @Autowired
    private IReseniaRepository resRepository;

    // Implementacion de Metodos CRUD
    @Override
    public List<Resenia> list() {
        return resRepository.findAll();
    }

    @Override
    public void insert(Resenia rese) {
        resRepository.save(rese);
    }

    @Override
    public void update(Resenia rese) {
        resRepository.save(rese);
    }

    @Override
    public void delete(int id) {
        resRepository.deleteById(id);
    }

    @Override
    public Resenia searchId(int id) {
        return resRepository.findById(id).orElse(new Resenia());
    }

    // Implementación de queries personalizadas
    @Override
    public List<ReseniasPorTrabajadorDTO> obtenerReseniasPorTrabajador() {
        List<Object[]> results = resRepository.contarReseniasPorTrabajador();
        List<ReseniasPorTrabajadorDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            ReseniasPorTrabajadorDTO dto = new ReseniasPorTrabajadorDTO();
            dto.setIdTrabajador((Integer) result[0]);
            dto.setNombreTrabajador((String) result[1]);
            dto.setTotalResenias((Long) result[2]);
            dtos.add(dto);
        }

        return dtos;
    }
}

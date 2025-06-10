package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Notificacion;
import pe.edu.upc.domesticgo.entities.Ubicacion;
import pe.edu.upc.domesticgo.repositories.IUbicacionRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IUbicacionService;

import java.util.List;

@Service
public class UbicacionServiceImplement implements IUbicacionService {
    @Autowired
    private IUbicacionRepository ubiRepository;


    // Implementacion de Metodos CRUD
    @Override
    public List<Ubicacion> list() {
        return ubiRepository.findAll();
    }

    @Override
    public void insert(Ubicacion ubic) {
        ubiRepository.save(ubic);
    }

    @Override
    public void update(Ubicacion ubic) {
        ubiRepository.save(ubic);
    }

    @Override
    public void delete(int id) {
        ubiRepository.deleteById(id);
    }

    @Override
    public Ubicacion searchId(int id) {
        return ubiRepository.findById(id).orElse(new Ubicacion());
    }
}

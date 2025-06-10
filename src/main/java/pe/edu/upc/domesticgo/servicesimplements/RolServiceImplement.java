package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Rol;
import pe.edu.upc.domesticgo.repositories.IRolRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rolRepository;


    // Implementacion de Metodos CRUD
    @Override
    public List<Rol> list() {
        return rolRepository.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void update(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(int id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Rol searchId(int id) {
        return rolRepository.findById(id).orElse(new Rol());
    }
}

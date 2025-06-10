package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.PruebaCliente;
import pe.edu.upc.domesticgo.repositories.IPruebaClienteRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IPruebaClienteService;

import java.util.List;

@Service
public class PruebaClienteServiceImplement implements IPruebaClienteService {

    @Autowired
    private IPruebaClienteRepository PClieRepository;

    @Override
    public List<PruebaCliente> list() {
        return PClieRepository.findAll();
    }

    @Override
    public void insert(PruebaCliente user) {
        PClieRepository.save(user);
    }

    @Override
    public void update(PruebaCliente user) {
        PClieRepository.save(user);
    }

    @Override
    public void delete(int id) {
        PClieRepository.deleteById(id);
    }

    @Override
    public PruebaCliente searchId(int id) {
        return PClieRepository.findById(id).orElse(new PruebaCliente());
    }
}

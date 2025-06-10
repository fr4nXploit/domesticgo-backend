package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Contrato;
import pe.edu.upc.domesticgo.repositories.IContratoRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IContratoService;

import java.util.List;

@Service
public class ContratoServiceImplement implements IContratoService {
    @Autowired
    private IContratoRepository conRepository;


    // Implementacion de Metodos CRUD
    @Override
    public List<Contrato> list() {
        return conRepository.findAll();
    }

    @Override
    public void insert(Contrato cont) {
        conRepository.save(cont);
    }

    @Override
    public void update(Contrato cont) {
        conRepository.save(cont);
    }

    @Override
    public void delete(int id) {
        conRepository.deleteById(id);
    }

    @Override
    public Contrato searchId(int id) {
        return conRepository.findById(id).orElse(new Contrato());
    }
}

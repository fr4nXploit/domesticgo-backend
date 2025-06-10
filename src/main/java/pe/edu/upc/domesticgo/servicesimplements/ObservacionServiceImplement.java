package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Observacion;
import pe.edu.upc.domesticgo.repositories.IObservacionRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IObservacionService;

import java.util.List;

@Service
public class ObservacionServiceImplement implements IObservacionService {
    @Autowired
    private IObservacionRepository obsRepository;

    // Implementacion de Metodos CRUD
    @Override
    public List<Observacion> list() {
        return obsRepository.findAll();
    }

    @Override
    public void insert(Observacion obse) {
        obsRepository.save(obse);
    }

    @Override
    public void update(Observacion obse) {
        obsRepository.save(obse);
    }

    @Override
    public void delete(int id) {
        obsRepository.deleteById(id);
    }

    @Override
    public Observacion searchId(int id) {
        return obsRepository.findById(id).orElse(new Observacion());
    }
}

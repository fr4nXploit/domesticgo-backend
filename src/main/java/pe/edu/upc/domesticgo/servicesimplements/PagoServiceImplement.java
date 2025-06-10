package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Pago;
import pe.edu.upc.domesticgo.repositories.IPagoRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IPagoService;

import java.util.List;

@Service
public class PagoServiceImplement implements IPagoService {
    @Autowired
    private IPagoRepository pagRepository;


    // Implementacion de Metodos CRUD
    @Override
    public List<Pago> list() {
        return pagRepository.findAll();
    }

    @Override
    public void insert(Pago noti) {
        pagRepository.save(noti);
    }

    @Override
    public void update(Pago noti) {
        pagRepository.save(noti);
    }

    @Override
    public void delete(int id) {
        pagRepository.deleteById(id);
    }

    @Override
    public Pago searchId(int id) {
        return pagRepository.findById(id).orElse(new Pago());
    }
}

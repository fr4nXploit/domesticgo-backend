package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Notificacion;
import pe.edu.upc.domesticgo.repositories.INotificacionRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.INotificacionService;

import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {

    @Autowired
    private INotificacionRepository notiRepository;

    // Implementacion de Metodos CRUD
    @Override
    public List<Notificacion> list() {
        return notiRepository.findAll();
    }

    @Override
    public void insert(Notificacion noti) {
        notiRepository.save(noti);
    }

    @Override
    public void update(Notificacion noti) {
        notiRepository.save(noti);
    }

    @Override
    public void delete(int id) {
        notiRepository.deleteById(id);
    }

    @Override
    public Notificacion searchId(int id) {
        return notiRepository.findById(id).orElse(new Notificacion());
    }
}

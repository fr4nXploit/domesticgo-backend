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
    private INotificacionRepository notificacionRepository;

    // Implementacion de Metodos CRUD
    @Override
    public List<Notificacion> list() {
        return notificacionRepository.findAll();
    }

    @Override
    public void insert(Notificacion noti) {
        notificacionRepository.save(noti);
    }

    @Override
    public void update(Notificacion noti) {
        notificacionRepository.save(noti);
    }

    @Override
    public void delete(int id) {
        notificacionRepository.deleteById(id);
    }

    @Override
    public Notificacion searchId(int id) {
        return notificacionRepository.findById(id).orElse(new Notificacion());
    }
}

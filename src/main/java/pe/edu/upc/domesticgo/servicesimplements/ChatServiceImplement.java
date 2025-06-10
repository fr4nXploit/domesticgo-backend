package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Chat;
import pe.edu.upc.domesticgo.repositories.IChatRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IChatService;

import java.util.List;

@Service
public class ChatServiceImplement implements IChatService {

    @Autowired
    private IChatRepository chatRepository;

    // Implementacion de Metodos CRUD
    @Override
    public List<Chat> list() {
        return chatRepository.findAll();
    }

    @Override
    public void insert(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public void update(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public void delete(int id) {
        chatRepository.deleteById(id);
    }

    @Override
    public Chat searchId(int id) {
        return chatRepository.findById(id).orElse(new Chat());
    }

}

package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Chat;

import java.util.List;

public interface IChatService {
    //Metodos de CRUD
    public List<Chat> list();
    public void insert(Chat chat);
    public void update(Chat chat);
    public void delete(int id);
    public Chat searchId(int id);
}

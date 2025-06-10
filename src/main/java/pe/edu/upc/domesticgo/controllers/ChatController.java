package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ChatDTO;
import pe.edu.upc.domesticgo.entities.Chat;
import pe.edu.upc.domesticgo.servicesinterfaces.IChatService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private IChatService chatService;

    // Metodos CRUD (listar, registrar, modificar, eliminar, listarId)

    @GetMapping("/listado")
    public List<ChatDTO> listar() {
        return chatService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ChatDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody ChatDTO chatDto){
        ModelMapper m=new ModelMapper();
        Chat chat=m.map(chatDto, Chat.class);
        chatService.insert(chat);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody ChatDTO chatDto){
        ModelMapper m=new ModelMapper();
        Chat chat=m.map(chatDto, Chat.class);
        chatService.update(chat);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        chatService.delete(id);
    }

    @GetMapping("/{id}")
    public ChatDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ChatDTO dto=m.map(chatService.searchId(id), ChatDTO.class);
        return dto;
    }

    // Queries


}

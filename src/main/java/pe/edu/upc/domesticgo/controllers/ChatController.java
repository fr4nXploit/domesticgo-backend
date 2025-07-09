package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<ChatDTO> listar() {
        return chatService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ChatDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody ChatDTO chatDto){
        ModelMapper m=new ModelMapper();
        Chat chat=m.map(chatDto, Chat.class);
        chatService.insert(chat);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ChatDTO chatDto){
        ModelMapper m=new ModelMapper();
        Chat chat=m.map(chatDto, Chat.class);
        chatService.update(chat);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        chatService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ChatDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ChatDTO dto=m.map(chatService.searchId(id), ChatDTO.class);
        return dto;
    }
}

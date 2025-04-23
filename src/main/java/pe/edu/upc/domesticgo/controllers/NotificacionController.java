package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.NotificacionDTO;
import pe.edu.upc.domesticgo.entities.Notificacion;
import pe.edu.upc.domesticgo.servicesinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService notiService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<Notificacion> listar() {
        return notiService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, Notificacion.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody NotificacionDTO notiDto){
        ModelMapper m=new ModelMapper();
        Notificacion noti=m.map(notiDto, Notificacion.class);
        notiService.insert(noti);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody NotificacionDTO notiDto){
        ModelMapper m=new ModelMapper();
        Notificacion noti=m.map(notiDto, Notificacion.class);
        notiService.update(noti);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        notiService.delete(id);
    }

    @GetMapping("/{id}")
    public NotificacionDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        NotificacionDTO dto=m.map(notiService.searchId(id), NotificacionDTO.class);
        return dto;
    }

    // Queries

}

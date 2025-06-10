package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ServicioDTO;
import pe.edu.upc.domesticgo.entities.Servicio;
import pe.edu.upc.domesticgo.servicesinterfaces.IServicioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private IServicioService servService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<ServicioDTO> listar() {
        return servService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ServicioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody ServicioDTO servDto){
        ModelMapper m=new ModelMapper();
        Servicio serv=m.map(servDto, Servicio.class);
        servService.insert(serv);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody ServicioDTO servDto){
        ModelMapper m=new ModelMapper();
        Servicio serv=m.map(servDto, Servicio.class);
        servService.update(serv);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        servService.delete(id);
    }

    @GetMapping("/{id}")
    public ServicioDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ServicioDTO dto=m.map(servService.searchId(id), ServicioDTO.class);
        return dto;
    }

    // Queries
}

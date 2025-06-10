package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.EmpleoDTO;
import pe.edu.upc.domesticgo.entities.Empleo;
import pe.edu.upc.domesticgo.servicesinterfaces.IEmpleoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleos")
public class EmpleoController {
    @Autowired
    private IEmpleoService emplService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<EmpleoDTO> listar() {
        return emplService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, EmpleoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody EmpleoDTO emplDto){
        ModelMapper m=new ModelMapper();
        Empleo empl=m.map(emplDto, Empleo.class);
        emplService.insert(empl);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody EmpleoDTO emplDto){
        ModelMapper m=new ModelMapper();
        Empleo empl=m.map(emplDto, Empleo.class);
        emplService.update(empl);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        emplService.delete(id);
    }

    @GetMapping("/{id}")
    public EmpleoDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        EmpleoDTO dto=m.map(emplService.searchId(id), EmpleoDTO.class);
        return dto;
    }
}

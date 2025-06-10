package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.RolDTO;
import pe.edu.upc.domesticgo.entities.Rol;
import pe.edu.upc.domesticgo.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rolService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<RolDTO> listar() {
        return rolService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody RolDTO rolDto){
        ModelMapper m=new ModelMapper();
        Rol rol=m.map(rolDto, Rol.class);
        rolService.insert(rol);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody RolDTO rolDto){
        ModelMapper m=new ModelMapper();
        Rol rol=m.map(rolDto, Rol.class);
        rolService.update(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        rolService.delete(id);
    }

    @GetMapping("/{id}")
    public RolDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        RolDTO dto=m.map(rolService.searchId(id), RolDTO.class);
        return dto;
    }

    // Queries
}

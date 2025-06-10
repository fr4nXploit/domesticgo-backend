package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.UbicacionDTO;
import pe.edu.upc.domesticgo.entities.Ubicacion;
import pe.edu.upc.domesticgo.servicesinterfaces.IUbicacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    @Autowired
    private IUbicacionService ubicService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<UbicacionDTO> listar() {
        return ubicService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, UbicacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody UbicacionDTO ubicDto){
        ModelMapper m=new ModelMapper();
        Ubicacion ubic=m.map(ubicDto, Ubicacion.class);
        ubicService.insert(ubic);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody UbicacionDTO ubicDto){
        ModelMapper m=new ModelMapper();
        Ubicacion ubic=m.map(ubicDto, Ubicacion.class);
        ubicService.update(ubic);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        ubicService.delete(id);
    }

    @GetMapping("/{id}")
    public UbicacionDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        UbicacionDTO dto=m.map(ubicService.searchId(id), UbicacionDTO.class);
        return dto;
    }

    // Queries
}

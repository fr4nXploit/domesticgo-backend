package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ObservacionDTO;
import pe.edu.upc.domesticgo.entities.Observacion;
import pe.edu.upc.domesticgo.servicesinterfaces.IObservacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/observaciones")
public class ObservacionController {

    @Autowired
    private IObservacionService obseService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<ObservacionDTO> listar() {
        return obseService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ObservacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody ObservacionDTO obseDto){
        ModelMapper m=new ModelMapper();
        Observacion obse=m.map(obseDto, Observacion.class);
        obseService.insert(obse);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody ObservacionDTO obseDto){
        ModelMapper m=new ModelMapper();
        Observacion obse=m.map(obseDto, Observacion.class);
        obseService.update(obse);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        obseService.delete(id);
    }

    @GetMapping("/{id}")
    public ObservacionDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ObservacionDTO dto=m.map(obseService.searchId(id), ObservacionDTO.class);
        return dto;
    }

    // Queries
}

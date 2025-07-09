package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<ObservacionDTO> listar() {
        return obseService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ObservacionDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody ObservacionDTO obseDto){
        ModelMapper m=new ModelMapper();
        Observacion obse=m.map(obseDto, Observacion.class);
        obseService.insert(obse);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ObservacionDTO obseDto){
        ModelMapper m=new ModelMapper();
        Observacion obse=m.map(obseDto, Observacion.class);
        obseService.update(obse);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        obseService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ObservacionDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ObservacionDTO dto=m.map(obseService.searchId(id), ObservacionDTO.class);
        return dto;
    }
}

package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ReservaDTO;
import pe.edu.upc.domesticgo.entities.Reserva;
import pe.edu.upc.domesticgo.servicesinterfaces.IReservaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private IReservaService reseService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<ReservaDTO> listar() {
        return reseService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ReservaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody ReservaDTO reseDto){
        ModelMapper m=new ModelMapper();
        Reserva rese=m.map(reseDto, Reserva.class);
        reseService.insert(rese);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody ReservaDTO reseDto){
        ModelMapper m=new ModelMapper();
        Reserva rese=m.map(reseDto, Reserva.class);
        reseService.update(rese);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        reseService.delete(id);
    }

    @GetMapping("/{id}")
    public ReservaDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ReservaDTO dto=m.map(reseService.searchId(id), ReservaDTO.class);
        return dto;
    }

    // Queries
}

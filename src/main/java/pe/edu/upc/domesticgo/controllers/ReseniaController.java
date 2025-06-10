package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ReseniaDTO;
import pe.edu.upc.domesticgo.entities.Resenia;
import pe.edu.upc.domesticgo.servicesinterfaces.IReseniaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenias")
public class ReseniaController {

    @Autowired
    private IReseniaService reseService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<ReseniaDTO> listar() {
        return reseService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ReseniaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody ReseniaDTO reseDto){
        ModelMapper m=new ModelMapper();
        Resenia rese=m.map(reseDto, Resenia.class);
        reseService.insert(rese);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody ReseniaDTO reseDto){
        ModelMapper m=new ModelMapper();
        Resenia rese=m.map(reseDto, Resenia.class);
        reseService.update(rese);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        reseService.delete(id);
    }

    @GetMapping("/{id}")
    public ReseniaDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ReseniaDTO dto=m.map(reseService.searchId(id), ReseniaDTO.class);
        return dto;
    }

    // Queries
}

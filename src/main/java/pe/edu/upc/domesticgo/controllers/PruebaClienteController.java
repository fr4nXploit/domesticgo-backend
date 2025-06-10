package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.PruebaClienteDTO;
import pe.edu.upc.domesticgo.entities.PruebaCliente;
import pe.edu.upc.domesticgo.servicesinterfaces.IPruebaClienteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prueba-cliente")
public class PruebaClienteController {

    @Autowired
    private IPruebaClienteService pClieService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<PruebaClienteDTO> listar() {
        return pClieService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, PruebaClienteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody PruebaClienteDTO usuaDto){
        ModelMapper m=new ModelMapper();
        PruebaCliente usua=m.map(usuaDto, PruebaCliente.class);
        pClieService.insert(usua);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody PruebaClienteDTO usuaDto){
        ModelMapper m=new ModelMapper();
        PruebaCliente usua=m.map(usuaDto, PruebaCliente.class);
        pClieService.update(usua);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        pClieService.delete(id);
    }

    @GetMapping("/{id}")
    public PruebaClienteDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        PruebaClienteDTO dto=m.map(pClieService.searchId(id), PruebaClienteDTO.class);
        return dto;
    }

    //Queries

}

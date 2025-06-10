package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ContratoDTO;
import pe.edu.upc.domesticgo.entities.Contrato;
import pe.edu.upc.domesticgo.servicesinterfaces.IContratoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private IContratoService contService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<ContratoDTO> listar() {
        return contService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ContratoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody ContratoDTO contDto){
        ModelMapper m=new ModelMapper();
        Contrato cont=m.map(contDto, Contrato.class);
        contService.insert(cont);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody ContratoDTO contDto){
        ModelMapper m=new ModelMapper();
        Contrato cont=m.map(contDto, Contrato.class);
        contService.update(cont);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        contService.delete(id);
    }

    @GetMapping("/{id}")
    public ContratoDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ContratoDTO dto=m.map(contService.searchId(id), ContratoDTO.class);
        return dto;
    }

    // Queries
}

package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.PagoDTO;
import pe.edu.upc.domesticgo.entities.Pago;
import pe.edu.upc.domesticgo.servicesinterfaces.IPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private IPagoService pagService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<PagoDTO> listar() {
        return pagService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody PagoDTO pagDto){
        ModelMapper m=new ModelMapper();
        Pago pag=m.map(pagDto, Pago.class);
        pagService.insert(pag);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody PagoDTO pagDto){
        ModelMapper m=new ModelMapper();
        Pago pag=m.map(pagDto, Pago.class);
        pagService.update(pag);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        pagService.delete(id);
    }

    @GetMapping("/{id}")
    public PagoDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        PagoDTO dto=m.map(pagService.searchId(id), PagoDTO.class);
        return dto;
    }

    // Queries
}

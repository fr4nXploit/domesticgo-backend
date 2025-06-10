package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Usuario;
import pe.edu.upc.domesticgo.repositories.IUsuarioRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuRepository;


    // Implementacion de Metodos CRUD
    @Override
    public List<Usuario> list() {
        return usuRepository.findAll();
    }

    @Override
    public void insert(Usuario usua) {
        usuRepository.save(usua);
    }

    @Override
    public void update(Usuario usua) {
        usuRepository.save(usua);
    }

    @Override
    public void delete(int id) {
        usuRepository.deleteById(id);
    }

    @Override
    public Usuario searchId(int id) {
        return usuRepository.findById(id).orElse(new Usuario());
    }
}

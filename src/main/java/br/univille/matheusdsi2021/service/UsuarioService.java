package br.univille.matheusdsi2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.matheusdsi2021.model.Usuario;


@Service
public interface UsuarioService {
    public List<Usuario> getAll();
    public void save(Usuario usuario);
    public void delete(Usuario usuario);
    
}

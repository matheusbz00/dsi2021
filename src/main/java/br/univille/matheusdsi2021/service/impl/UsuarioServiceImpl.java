package br.univille.matheusdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.matheusdsi2021.model.Usuario;
import br.univille.matheusdsi2021.repository.UsuarioRepository;
import br.univille.matheusdsi2021.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

	@Override
	public List<Usuario> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		repository.save(usuario);
	}
	
	@Override
    public void delete(Usuario usuario) {
        repository.delete(usuario);
    }
}

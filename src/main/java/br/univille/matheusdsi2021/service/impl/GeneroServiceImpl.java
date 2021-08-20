package br.univille.matheusdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.matheusdsi2021.model.Genero;
import br.univille.matheusdsi2021.repository.GeneroRepository;
import br.univille.matheusdsi2021.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    private GeneroRepository repository;

	@Override
	public List<Genero> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Genero genero) {
		repository.save(genero);
	}
	
	@Override
    public void delete(Genero genero) {
        repository.delete(genero);
    }
}

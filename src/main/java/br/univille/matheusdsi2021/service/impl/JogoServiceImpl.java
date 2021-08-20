package br.univille.matheusdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.matheusdsi2021.model.Jogo;
import br.univille.matheusdsi2021.repository.JogoRepository;
import br.univille.matheusdsi2021.service.JogoService;

@Service
public class JogoServiceImpl implements JogoService{

    @Autowired
    private JogoRepository repository;

	@Override
	public List<Jogo> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Jogo jogo) {
		repository.save(jogo);
	}
	
	@Override
    public void delete(Jogo jogo) {
        repository.delete(jogo);
    }
}

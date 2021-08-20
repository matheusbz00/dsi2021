package br.univille.matheusdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.matheusdsi2021.model.Produtora;
import br.univille.matheusdsi2021.repository.ProdutoraRepository;
import br.univille.matheusdsi2021.service.ProdutoraService;

@Service
public class ProdutoraServiceImpl implements ProdutoraService{

    @Autowired
    private ProdutoraRepository repository;

	@Override
	public List<Produtora> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Produtora produtora) {
		repository.save(produtora);
	}
	
	@Override
    public void delete(Produtora produtora) {
        repository.delete(produtora);
    }
}

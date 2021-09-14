package br.univille.matheusdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.matheusdsi2021.model.Publicacao;
import br.univille.matheusdsi2021.repository.PublicacaoRepository;
import br.univille.matheusdsi2021.service.PublicacaoService;

@Service
public class PublicacaoServiceImpl implements PublicacaoService{

    @Autowired
    private PublicacaoRepository repository;

    @Override
    public List<Publicacao> getAll() {
        return repository.findAllTopTenByOrderByDataPublicacaoDesc();
    }

    @Override
    public void save(Publicacao publicacao) {
        repository.save(publicacao);

    }

}
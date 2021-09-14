package br.univille.matheusdsi2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.matheusdsi2021.model.Publicacao;

@Service
public interface PublicacaoService {
    public List<Publicacao> getAll();
    public void save(Publicacao publicacao);
}
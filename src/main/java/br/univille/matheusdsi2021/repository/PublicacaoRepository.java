package br.univille.matheusdsi2021.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.matheusdsi2021.model.Publicacao;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao,Long>{
    List<Publicacao> findAllTopTenByOrderByDataPublicacaoDesc();
}
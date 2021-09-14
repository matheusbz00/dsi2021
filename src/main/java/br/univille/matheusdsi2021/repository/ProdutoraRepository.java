package br.univille.matheusdsi2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.matheusdsi2021.model.Produtora;

@Repository
public interface ProdutoraRepository extends JpaRepository<Produtora,Long>{

}
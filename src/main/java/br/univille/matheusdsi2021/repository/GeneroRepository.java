package br.univille.matheusdsi2021.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.matheusdsi2021.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Long> {
    //List<Genero> findByNomeContains(String descricao);
    
}

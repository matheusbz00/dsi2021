package br.univille.matheusdsi2021.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.matheusdsi2021.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo,Long> {
    //List<Jogo> findByNomeContains(String descricao);
    
}

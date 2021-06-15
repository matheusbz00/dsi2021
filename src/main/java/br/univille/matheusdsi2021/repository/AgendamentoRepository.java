package br.univille.matheusdsi2021.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.matheusdsi2021.model.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
    List<Agendamento> findByNomeContains(String descricao);
    
}

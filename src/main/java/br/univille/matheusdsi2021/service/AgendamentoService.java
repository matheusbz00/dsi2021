package br.univille.matheusdsi2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.matheusdsi2021.model.Agendamento;


@Service
public interface AgendamentoService {
    public List<Agendamento> getAll();
    public void save(Agendamento agendamento);
    
}

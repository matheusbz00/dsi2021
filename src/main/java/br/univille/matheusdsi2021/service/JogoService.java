package br.univille.matheusdsi2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.matheusdsi2021.model.Jogo;


@Service
public interface JogoService {
    public List<Jogo> getAll();
    public void save(Jogo jogo);
    public void delete(Jogo jogo);
    
}

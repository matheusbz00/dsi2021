package br.univille.matheusdsi2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.matheusdsi2021.model.Genero;


@Service
public interface GeneroService {
    public List<Genero> getAll();
    public void save(Genero genero);
    public void delete(Genero genero);
    
}

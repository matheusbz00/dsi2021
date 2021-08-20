package br.univille.matheusdsi2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.matheusdsi2021.model.Produtora;


@Service
public interface ProdutoraService {
    public List<Produtora> getAll();
    public void save(Produtora produtora);
    public void delete(Produtora produtora);
    
}

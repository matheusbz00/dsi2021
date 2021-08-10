package br.univille.matheusdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.matheusdsi2021.model.Agendamento;
import br.univille.matheusdsi2021.repository.AgendamentoRepository;
import br.univille.matheusdsi2021.service.AgendamentoService;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

    @Autowired
    private AgendamentoRepository repository;

	@Override
	public List<Agendamento> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Agendamento agendamento) {
		repository.save(agendamento);
	}
	
	@Override
    public void delete(Agendamento agendamento) {
        repository.delete(agendamento);
    }
}

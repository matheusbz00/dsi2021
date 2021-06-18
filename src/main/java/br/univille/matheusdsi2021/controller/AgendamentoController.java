package br.univille.matheusdsi2021.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.univille.matheusdsi2021.model.Agendamento;
import br.univille.matheusdsi2021.service.AgendamentoService;


@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping
    public ModelAndView index(){
        List<Agendamento> listaAgendamentos = service.getAll();
        return new ModelAndView("agendamento/index", "listaAgendamentos", listaAgendamentos);
    }
    
}

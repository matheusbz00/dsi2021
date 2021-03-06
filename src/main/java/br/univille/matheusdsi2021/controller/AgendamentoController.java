package br.univille.matheusdsi2021.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Agendamento agendamento){
        return new ModelAndView("agendamento/form");
    }

    @PostMapping(params="form")
    public ModelAndView save(Agendamento agendamento){
        service.save(agendamento);
        return new ModelAndView("redirect:/agendamento");

    }

    @GetMapping("alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Agendamento agendamento){
        System.out.println(agendamento.getDescricao());
        return new ModelAndView("/agendamento/form","agendamento",agendamento);

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Agendamento agendamento){
        service.delete(agendamento);
        return new ModelAndView("redirect:/agendamento");
    }
    
}

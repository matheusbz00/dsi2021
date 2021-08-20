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
import br.univille.matheusdsi2021.model.Jogo;
import br.univille.matheusdsi2021.service.JogoService;


@Controller
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping
    public ModelAndView index(){
        List<Jogo> listaJogos = service.getAll();
        return new ModelAndView("jogo/index", "listaJogos", listaJogos);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Jogo jogo){
        return new ModelAndView("jogo/form");
    }

    @PostMapping(params="form")
    public ModelAndView save(Jogo jogo){
        service.save(jogo);
        return new ModelAndView("redirect:/jogo");

    }

    @GetMapping("alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Jogo jogo){
        System.out.println(jogo.getNome());
        return new ModelAndView("/jogo/form","jogo",jogo);

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Jogo jogo){
        service.delete(jogo);
        return new ModelAndView("redirect:/jogo");
    }
    
}

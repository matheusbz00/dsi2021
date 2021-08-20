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
import br.univille.matheusdsi2021.model.Genero;
import br.univille.matheusdsi2021.service.GeneroService;


@Controller
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService service;

    @GetMapping
    public ModelAndView index(){
        List<Genero> listaGeneros = service.getAll();
        return new ModelAndView("genero/index", "listaGeneros", listaGeneros);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Genero genero){
        return new ModelAndView("genero/form");
    }

    @PostMapping(params="form")
    public ModelAndView save(Genero genero){
        service.save(genero);
        return new ModelAndView("redirect:/genero");

    }

    @GetMapping("alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Genero genero){
        System.out.println(genero.getNome());
        return new ModelAndView("/genero/form","genero",genero);

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Genero genero){
        service.delete(genero);
        return new ModelAndView("redirect:/genero");
    }
    
}

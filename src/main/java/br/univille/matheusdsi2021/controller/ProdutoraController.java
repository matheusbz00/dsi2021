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

import br.univille.matheusdsi2021.model.Produtora;
import br.univille.matheusdsi2021.service.ProdutoraService;

@Controller
@RequestMapping("/produtora")
public class ProdutoraController {

    @Autowired
    private ProdutoraService service;

    @GetMapping
    public ModelAndView index(){
        List<Produtora> listaProdutoras = service.getAll();
        return new ModelAndView("produtora/index", "listaProdutoras", listaProdutoras);    
    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Produtora produtora){
        return new ModelAndView("produtora/form");
    }
    @PostMapping(params="form")
    public ModelAndView save(Produtora produtora){
        service.save(produtora);
        return new ModelAndView("redirect:/produtora");
    }

    @GetMapping("alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Produtora produtora){
        return new ModelAndView("/produtora/form","produtora",produtora);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Produtora produtora){
        service.delete(produtora);
        return new ModelAndView("redirect:/produtora");
    }
}
package br.univille.matheusdsi2021.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.matheusdsi2021.model.Publicacao;
import br.univille.matheusdsi2021.service.PublicacaoService;

@Controller
@RequestMapping("/publicacao")
public class PublicacaoController {

    @Autowired
    private PublicacaoService service;

    @GetMapping
    public ModelAndView index(){
        HashMap<String,Object> dados = new HashMap<>();
        List<Publicacao> listaPublicacaos = service.getAll();
        dados.put("listaPublicacaos", listaPublicacaos);
        dados.put("publicacao", new Publicacao());
        return new ModelAndView("publicacao/index", dados);    
    }

    @PostMapping(params="form")
    public ModelAndView save(Publicacao publicacao){
        publicacao.setDataPublicacao(new Date());
        service.save(publicacao);
        return new ModelAndView("redirect:/publicacao");
    }

}
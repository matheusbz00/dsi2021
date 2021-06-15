package br.univille.matheusdsi2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("agendamento/index");
    }
    
}

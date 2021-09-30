package br.univille.matheusdsi2021.controller;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.univille.matheusdsi2021.model.Usuario;
import br.univille.matheusdsi2021.service.UsuarioService;
import br.univille.matheusdsi2021.service.StorageFilesService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private StorageFilesService storageFilesService;

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ModelAndView index(){
        List<Usuario> listaUsuarios = service.getAll();
        return new ModelAndView("usuario/index", "listaUsuarios", listaUsuarios);    
    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Usuario usuario){
        return new ModelAndView("usuario/form");
    }

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute Usuario usuario){
        return new ModelAndView("usuario/login");
    }

    @PostMapping(params="form")
    public ModelAndView save(Usuario usuario, @RequestParam("file") MultipartFile file){
        if(file.getSize() != 0){
            String caminho = storageFilesService.save(file);
            usuario.setFoto(caminho);
        }
        service.save(usuario);
        return new ModelAndView("redirect:/usuario");
    }
    @GetMapping(value = "/image/{id}")
    public @ResponseBody byte[] getImage(@PathVariable("id") Usuario usuario){
        try{
            File file = new File(usuario.getFoto());
            byte[] bytes = new byte[(int) file.length()];
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            dis.readFully(bytes);
            return bytes;
        }catch (Exception e){
            return new byte[0];
        }
    }

    @GetMapping("alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Usuario usuario){
        System.out.println(usuario.getNome());
        return new ModelAndView("/usuario/form","usuario",usuario);

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Usuario usuario){
        service.delete(usuario);
        return new ModelAndView("redirect:/usuario");
    }
}
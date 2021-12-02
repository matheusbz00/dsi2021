package br.univille.matheusdsi2021.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;

import br.univille.matheusdsi2021.model.Usuario;
import br.univille.matheusdsi2021.repository.UsuarioRepository;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario buscaUsuarioSenha(String loginUsuario, String senhaUsuario){
        return repository.findByLoginAndSenha(loginUsuario, senhaUsuario);
    }

    @Override
    public UserDetails loadUserByUsername(String loginUsuario) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(loginUsuario);
        return new User(usuario.getLogin(),usuario.getSenha(), new ArrayList<>());
    }   

}
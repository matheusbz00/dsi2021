package br.univille.matheusdsi2021.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String genero;
    private String plataformas;
    private String modos;
    private Date dataLancamento;
    private int faixaEtaria;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name="usuario_id")
    private List<Usuario> usuario = 
        new ArrayList<Usuario>();
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getPlataformas() {
        return plataformas;
    }
    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }
    public String getModos() {
        return modos;
    }
    public void setModos(String modos) {
        this.modos = modos;
    }
    public Date getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public int getFaixaEtaria() {
        return faixaEtaria;
    }
    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    


}
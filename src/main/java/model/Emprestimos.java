/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Emprestimos implements Serializable {
    private String nome;
    private String contacto;
    private String bi;
    private double valor;
    private String endereco;
    private LocalDateTime dataLimite;
    private int quantidade;
    private int livroId; 
    private String tituloLivro; 

    public Emprestimos(String nome, String contacto, String bi, double valor, String endereco, LocalDateTime dataLimite, int quantidade, int livroId, String tituloLivro) {
        this.nome = nome;
        this.contacto = contacto;
        this.bi = bi;
        this.valor = valor;
        this.endereco = endereco;
        this.dataLimite = dataLimite;
        this.quantidade = quantidade;
        this.livroId = livroId;
        this.tituloLivro = tituloLivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    
    
}

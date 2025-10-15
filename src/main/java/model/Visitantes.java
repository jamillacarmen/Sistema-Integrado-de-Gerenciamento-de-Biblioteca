/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
import java.time.LocalDate;


public class Visitantes implements Serializable {

    private String nome;
    private String contacto;
    private LocalDate dataVisita;
    private int livroId; // ID do livro selecionado
    private String tituloLivro; // Titulo do livro selecionado
    

    public Visitantes(String nome, String contacto, LocalDate dataVisita, int livroId, String tituloLivro) {
        this.nome = nome;
        this.contacto = contacto;
        this.dataVisita = dataVisita;
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

    public LocalDate getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
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

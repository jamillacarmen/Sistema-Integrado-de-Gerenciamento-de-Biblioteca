/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

public class Livros implements Serializable {
    private int idLivro;
    private String autor;
    private String genero;//categoria
    private String titulo;
    private int numLivros;
    private boolean status;
    private double valorLivro;

    public Livros(int idLivro, String autor, String genero, String titulo, int numLivros, boolean status, double valorLivro) {
        this.idLivro = idLivro;
        this.autor = autor;
        this.genero = genero;
        this.titulo = titulo;
        this.numLivros = numLivros;
        this.status = status;
        this.valorLivro = valorLivro;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumLivros() {
        return numLivros;
    }

    public void setNumLivros(int numLivros) {
        this.numLivros = numLivros;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getValorLivro() {
        return valorLivro;
    }

    public void setValorLivro(double valorLivro) {
        this.valorLivro = valorLivro;
    }
    
    

}
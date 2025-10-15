/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import model.Livros;
import java.util.List;
import java.util.ArrayList;

public class LivrosDAO extends BaseDAO {
    private static final String ARQUIVO = "livros.dat";
    private List<Livros> livros;

    public LivrosDAO() {
        livros = carregarDados(ARQUIVO);
    }

    public void salvarLivro(Livros livro) {
        // Verificar se já existe (atualizar) ou adicionar novo
        boolean existe = false;
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getIdLivro() == livro.getIdLivro()) {
                livros.set(i, livro);
                existe = true;
                break;
            }
        }
        if (!existe) {
            livros.add(livro);
        }
        salvarDados(ARQUIVO, livros);
    }

    public List<Livros> listarLivros() {
        return new ArrayList<>(livros);
    }

    public Livros buscarPorId(int id) {
        for (Livros livro : livros) {
            if (livro.getIdLivro() == id) {
                return livro;
            }
        }
        return null;
    }

    public List<Livros> buscarPorTitulo(String titulo) {
        List<Livros> resultado = new ArrayList<>();
        for (Livros livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public List<Livros> buscarPorAutor(String autor) {
        List<Livros> resultado = new ArrayList<>();
        for (Livros livro : livros) {
            if (livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public List<Livros> buscarPorGenero(String genero) {
        List<Livros> resultado = new ArrayList<>();
        for (Livros livro : livros) {
            if (livro.getGenero().toLowerCase().contains(genero.toLowerCase())) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public void atualizarLivro(Livros livroAtualizado) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getIdLivro() == livroAtualizado.getIdLivro()) {
                livros.set(i, livroAtualizado);
                salvarDados(ARQUIVO, livros);
                break;
            }
        }
    }

    public void removerLivro(int id) {
        livros.removeIf(livro -> livro.getIdLivro() == id);
        salvarDados(ARQUIVO, livros);
    }

    public int getTotalLivros() {
        return livros.size();
    }

    public int getTotalExemplares() {
        int total = 0;
        for (Livros livro : livros) {
            total += livro.getNumLivros();
        }
        return total;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import model.Bibliotecario;
import java.util.List;
import java.util.ArrayList;

public class BibliotecarioDAO extends BaseDAO {
    private static final String ARQUIVO = "bibliotecarios.dat";
    private List<Bibliotecario> bibliotecarios;

    public BibliotecarioDAO() {
        bibliotecarios = carregarDados(ARQUIVO);
    }

    public void salvarBibliotecario(Bibliotecario bibliotecario) {
        // Verificar se já existe (atualizar) ou adicionar novo
        boolean existe = false;
        for (int i = 0; i < bibliotecarios.size(); i++) {
            if (bibliotecarios.get(i).getId() == bibliotecario.getId()) {
                bibliotecarios.set(i, bibliotecario);
                existe = true;
                break;
            }
        }
        if (!existe) {
            bibliotecarios.add(bibliotecario);
        }
        salvarDados(ARQUIVO, bibliotecarios);
    }

    public List<Bibliotecario> listarBibliotecarios() {
        return new ArrayList<>(bibliotecarios);
    }

    public Bibliotecario buscarPorId(int id) {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getId() == id) {
                return bibliotecario;
            }
        }
        return null;
    }

    public Bibliotecario buscarPorBi(String bi) {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getBi().equals(bi)) {
                return bibliotecario;
            }
        }
        return null;
    }

    public boolean autenticar(int id, String senha) {
        Bibliotecario bibliotecario = buscarPorId(id);
        return bibliotecario != null && bibliotecario.getSenha().equals(senha);
    }

    public boolean alterarSenha(int id, String senhaAntiga, String novaSenha) {
        Bibliotecario bibliotecario = buscarPorId(id);
        if (bibliotecario != null && bibliotecario.getSenha().equals(senhaAntiga)) {
            bibliotecario.setSenha(novaSenha);
            salvarDados(ARQUIVO, bibliotecarios);
            return true;
        }
        return false;
    }

    public void removerBibliotecario(int id) {
        bibliotecarios.removeIf(bibliotecario -> bibliotecario.getId() == id);
        salvarDados(ARQUIVO, bibliotecarios);
    }

    public boolean existeBibliotecarioComBi(String bi) {
        return buscarPorBi(bi) != null;
    }
}

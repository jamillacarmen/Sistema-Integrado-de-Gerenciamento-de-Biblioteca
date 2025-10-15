/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import model.Gestor;
import java.util.List;
import java.util.ArrayList;

public class GestorDAO extends BaseDAO {
    private static final String ARQUIVO = "gestores.dat";
    private List<Gestor> gestores;

    public GestorDAO() {
        gestores = carregarDados(ARQUIVO);
    }

    public void salvarGestor(Gestor gestor) {
        // Verificar se já existe (atualizar) ou adicionar novo
        boolean existe = false;
        for (int i = 0; i < gestores.size(); i++) {
            if (gestores.get(i).getId() == gestor.getId()) {
                gestores.set(i, gestor);
                existe = true;
                break;
            }
        }
        if (!existe) {
            gestores.add(gestor);
        }
        salvarDados(ARQUIVO, gestores);
    }

    public List<Gestor> listarGestores() {
        return new ArrayList<>(gestores);
    }

    public Gestor buscarPorId(int id) {
        for (Gestor gestor : gestores) {
            if (gestor.getId() == id) {
                return gestor;
            }
        }
        return null;
    }

    public Gestor buscarPorBi(String bi) {
        for (Gestor gestor : gestores) {
            if (gestor.getBi().equals(bi)) {
                return gestor;
            }
        }
        return null;
    }

    public boolean autenticar(int id, String senha) {
        Gestor gestor = buscarPorId(id);
        return gestor != null && gestor.getSenha().equals(senha);
    }

    public boolean alterarSenha(int id, String senhaAntiga, String novaSenha) {
        Gestor gestor = buscarPorId(id);
        if (gestor != null && gestor.getSenha().equals(senhaAntiga)) {
            gestor.setSenha(novaSenha);
            salvarDados(ARQUIVO, gestores);
            return true;
        }
        return false;
    }

    public void removerGestor(int id) {
        gestores.removeIf(gestor -> gestor.getId() == id);
        salvarDados(ARQUIVO, gestores);
    }

    public boolean existeGestorComBi(String bi) {
        return buscarPorBi(bi) != null;
    }
}
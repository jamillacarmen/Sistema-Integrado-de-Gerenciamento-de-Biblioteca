/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfiguracaoDAO {
    
    private static final String ARQUIVO = "configuracao.dat";
    private Map<String, Object> configuracoes;

    public ConfiguracaoDAO() {
        configuracoes = carregarConfiguracoes();
        // Taxa padrao se nao existir
        if (!configuracoes.containsKey("taxaEmprestimo")) {
            configuracoes.put("taxaEmprestimo", 50.0);
        }
    }

    public void salvarTaxaEmprestimo(double taxa) {
        configuracoes.put("taxaEmprestimo", taxa);
        salvarConfiguracoes();
    }

    public double getTaxaEmprestimo() {
        return (Double) configuracoes.get("taxaEmprestimo");
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> carregarConfiguracoes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (Map<String, Object>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar configurações: " + e.getMessage());
            return new HashMap<>();
        }
    }

    private void salvarConfiguracoes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(configuracoes);
        } catch (IOException e) {
            System.err.println("Erro ao salvar configurações: " + e.getMessage());
        }
    }
}
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe base para Data Access Objects (DAOs) do sistema.
 * Fornece operações genéricas de persistência em arquivos para todas as entidades.
 * Implementa serialização de objetos para armazenamento em disco.
 */
public class BaseDAO {
    @SuppressWarnings("unchecked")
    /**
     * Carrega dados de um arquivo de persistência.
     * @param <T> o tipo dos objetos a serem carregados
     * @param arquivo o nome do arquivo de onde os dados serão carregados
     * @return lista de objetos carregados do arquivo, ou lista vazia se o arquivo não existir
     */
    protected <T> List<T> carregarDados(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<T>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar " + arquivo + ": " + e.getMessage());
            return new ArrayList<T>();
        }
    }

    protected <T> void salvarDados(String arquivo, List<T> dados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(dados);
        } catch (IOException e) {
            System.err.println("Erro ao salvar " + arquivo + ": " + e.getMessage());
        }
    }
}

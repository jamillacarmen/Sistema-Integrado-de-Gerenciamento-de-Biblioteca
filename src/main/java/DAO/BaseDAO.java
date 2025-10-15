/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDAO {
    @SuppressWarnings("unchecked")
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

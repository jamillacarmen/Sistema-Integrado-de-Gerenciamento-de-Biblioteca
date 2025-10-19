/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Visitantes;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Data Access Object para gerenciar dados dos visitantes da biblioteca.
 * Responsável por operações CRUD.
 */

public class VisitantesDAO extends BaseDAO {
    
    private static final String ARQUIVO = "visitantes.dat";
    private List<Visitantes> visitantes;

    public VisitantesDAO() {
        visitantes = carregarDados(ARQUIVO);
    }
    
    
    /**
     * Registra um novo visitante no sistema.
     * @param visitante o visitante a ser registrado
     */
    

    public void registrarVisitante(Visitantes visitante) {
       
        visitantes.add(visitante);
        salvarDados(ARQUIVO, visitantes);
    }

    public List<Visitantes> listarVisitantes() {
        return new ArrayList<>(visitantes);
    }
    
      /**
     * Conta quantos visitantes foram registrados hoje.
     * @return número de visitantes do dia atual
     */

    public int contarVisitantesHoje() {
    LocalDate hoje = LocalDate.now(); // sempre a data de hoje
    int count = 0;
    for (Visitantes v : visitantes) {
        if (v.getDataVisita().equals(hoje)) { // so conta se for hj, no dia seguinte comeca de novo
            count++;
        }
    }
    return count;
}

      /**
     * Busca visitantes por nome (busca parcial case-insensitive).
     * @param nome o nome ou parte do nome a buscar
     * @return lista de visitantes encontrados
     */
    
    public List<Visitantes> buscarPorNome(String nome) {
        List<Visitantes> resultado = new ArrayList<>();
        for (Visitantes visitante : visitantes) {
            if (visitante.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(visitante);
            }
        }
        return resultado;
    }

    public List<Visitantes> buscarPorContacto(String contacto) {
    List<Visitantes> resultado = new ArrayList<>();
    for (Visitantes visitante : visitantes) {
        
        if (visitante.getContacto().contains(contacto)) {
            resultado.add(visitante);
        }
    }
    return resultado;
}

    public int getTotalVisitantes() {
        return visitantes.size();
    }

    public int contarVisitantesPorData(String data) {
        int count = 0;
        for (Visitantes v : visitantes) {
            if (v.getDataVisita().equals(data)) {
                count++;
            }
        }
        return count;
    }
}

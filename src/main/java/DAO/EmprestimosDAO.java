/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import model.Emprestimos;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class EmprestimosDAO extends BaseDAO {
    private static final String ARQUIVO = "emprestimos.dat";
    private List<Emprestimos> emprestimos;

    public EmprestimosDAO() {
        emprestimos = carregarDados(ARQUIVO);
    }

    public void salvarEmprestimo(Emprestimos emprestimo) {
        emprestimos.add(emprestimo);
        salvarDados(ARQUIVO, emprestimos);
    }

    public List<Emprestimos> listarEmprestimos() {
        return new ArrayList<>(emprestimos);
    }

    public List<Emprestimos> buscarPorNome(String nome) {
        List<Emprestimos> resultado = new ArrayList<>();
        for (Emprestimos emp : emprestimos) {
            if (emp.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(emp);
            }
        }
        return resultado;
    }

    public List<Emprestimos> buscarPorBi(String bi) {
        List<Emprestimos> resultado = new ArrayList<>();
        for (Emprestimos emp : emprestimos) {
            if (emp.getBi().equals(bi)) {
                resultado.add(emp);
            }
        }
        return resultado;
    }

    public double calcularMulta(Emprestimos emprestimo) {
        if (LocalDateTime.now().isAfter(emprestimo.getDataLimite())) {
            long diasAtraso = java.time.Duration.between(emprestimo.getDataLimite(), LocalDateTime.now()).toDays();
            return diasAtraso * 50.0; // 50 MZN por dia de atraso
        }
        return 0.0;
    }

    public int contarLivrosEmprestadosHoje() {
        String hoje = LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int count = 0;
        for (Emprestimos emp : emprestimos) {
            String dataEmprestimo = emp.getDataLimite().minusDays(7).format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (dataEmprestimo.equals(hoje)) {
                count += emp.getQuantidade();
            }
        }
        return count;
    }

    public double calcularTotalMultas() {
        double total = 0;
        for (Emprestimos emp : emprestimos) {
            total += calcularMulta(emp);
        }
        return total;
    }

    public double calcularTotalReceita() {
        double total = 0;
        for (Emprestimos emp : emprestimos) {
            total += emp.getValor();
        }
        return total;
    }
}

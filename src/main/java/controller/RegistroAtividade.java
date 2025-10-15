// Arquivo: RegistroAtividade.java (no pacote controller)
package controller;

import model.Atividade;
import DAO.AtividadeDAO;

public class RegistroAtividade {
    private static AtividadeDAO atividadeDAO = new AtividadeDAO();
    
    // LOGIN/LOGOUT
    public static void registrarLogin(String nomeUsuario, String funcao) {
        Atividade atividade = new Atividade(nomeUsuario, funcao, "Login", 
            "Acesso concedido ao sistema", "Autenticação", "Sessão iniciada");
        atividadeDAO.registrarAtividade(atividade);
    }
    
    public static void registrarLogout(String nomeUsuario, String funcao) {
        Atividade atividade = new Atividade(nomeUsuario, funcao, "Logout", 
            "Sessão encerrada", "Autenticação", "Sessão finalizada");
        atividadeDAO.registrarAtividade(atividade);
    }
    
    // GESTOR - LIVROS
    public static void registrarCadastroLivro(String nomeUsuario, String funcao, 
                                             String tituloLivro, String autor, int quantidade) {
        Atividade atividade = new Atividade(nomeUsuario, funcao, "Cadastro de Livro", 
            "Novo livro adicionado à biblioteca", "Gestão de Livros",
            "Título: " + tituloLivro + " | Autor: " + autor + " | Quantidade: " + quantidade);
        atividadeDAO.registrarAtividade(atividade);
    }
    
    // GESTOR - TAXAS
    public static void registrarAlteracaoTaxa(String nomeUsuario, String funcao, 
                                             double taxaAntiga, double novaTaxa) {
        Atividade atividade = new Atividade(nomeUsuario, funcao, "Alteração de Taxa", 
            "Taxa de empréstimo modificada", "Configurações",
            "Taxa anterior: " + taxaAntiga + " MZN | Nova taxa: " + novaTaxa + " MZN");
        atividadeDAO.registrarAtividade(atividade);
    }
    
    // BIBLIOTECARIO - EMPRESTIMOS
    public static void registrarEmprestimo(String nomeUsuario, String funcao, 
                                          String nomeCliente, String biCliente, 
                                          int quantidade, double valor, String livros) {
        Atividade atividade = new Atividade(nomeUsuario, funcao, "Concessão de Empréstimo", 
            "Empréstimo concedido a cliente", "Empréstimos",
            "Cliente: " + nomeCliente + " | BI: " + biCliente + 
            " | Livros: " + quantidade + " | Valor: " + valor + " MZN | " + livros);
        atividadeDAO.registrarAtividade(atividade);
    }
    
    // BIBLIOTECARIO - VISITANTES
    public static void registrarVisitante(String nomeUsuario, String funcao, 
                                        String nomeVisitante, String contacto, String livroConsultado) {
        Atividade atividade = new Atividade(nomeUsuario, funcao, "Registro de Visitante", 
            "Novo visitante registrado", "Visitantes",
            "Nome: " + nomeVisitante + " | Contacto: " + contacto + 
            " | Livro consultado: " + livroConsultado);
        atividadeDAO.registrarAtividade(atividade);
    }
    
    // ADM - USUARIOS
    public static void registrarCadastroUsuario(String nomeUsuarioADM, String funcaoADM, 
                                               String novoUsuario, String cargo, int idNovoUsuario) {
        Atividade atividade = new Atividade(nomeUsuarioADM, funcaoADM, "Cadastro de Utilizador", 
            "Novo utilizador do sistema", "Gestão de Utilizadores",
            "Novo: " + novoUsuario + " | Cargo: " + cargo + " | ID: " + idNovoUsuario);
        atividadeDAO.registrarAtividade(atividade);
    }
    
    public static void registrarRemocaoUsuario(String nomeUsuarioADM, String funcaoADM, 
                                              String usuarioRemovido, String cargo, int idRemovido) {
        Atividade atividade = new Atividade(nomeUsuarioADM, funcaoADM, "Remoção de Utilizador", 
            "Utilizador removido do sistema", "Gestão de Utilizadores",
            "Removido: " + usuarioRemovido + " | Cargo: " + cargo + " | ID: " + idRemovido);
        atividadeDAO.registrarAtividade(atividade);
    }
    
    // MULTAS
    public static void registrarAplicacaoMulta(String nomeUsuario, String funcao, 
                                              String nomeCliente, double valorMulta, int diasAtraso) {
        Atividade atividade = new Atividade(nomeUsuario, funcao, "Aplicação de Multa", 
            "Multa aplicada por atraso", "Empréstimos",
            "Cliente: " + nomeCliente + " | Multa: " + valorMulta + 
            " MZN | Dias em atraso: " + diasAtraso);
        atividadeDAO.registrarAtividade(atividade);
    }
}
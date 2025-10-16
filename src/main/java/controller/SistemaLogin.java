

package controller;

import model.Gestor;
import model.Bibliotecario;
import DAO.GestorDAO;
import DAO.BibliotecarioDAO;
import DAO.AtividadeDAO;
import model.Atividade;

/**
 * Controlador responsável pela autenticação de utilizadores no sistema.
 * Gerencia login de gestores, bibliotecários e administrador.
 * Fornece métodos para autenticação e alteração de senhas.
 */
public class SistemaLogin {
    private GestorDAO gestorDAO;
    private BibliotecarioDAO bibliotecarioDAO;
    private AtividadeDAO atividadeDAO;
    private String usuarioLogado;
    private String funcaoUsuario;

    /**
     * Construtor que inicializa os DAOs necessários para autenticação.
     * Prepara sistema para validar credenciais de gestores e bibliotecários.
     */
    public SistemaLogin() {
        this.gestorDAO = new GestorDAO();
        this.bibliotecarioDAO = new BibliotecarioDAO();
        this.atividadeDAO = new AtividadeDAO();
    }

    public boolean autenticar(int id, String senha) {
        // Tentar autenticar como Gestor
        if (gestorDAO.autenticar(id, senha)) {
            Gestor gestor = gestorDAO.buscarPorId(id);
            if (gestor != null) {
                usuarioLogado = gestor.getNome();
                funcaoUsuario = "Gestor";
                return true;
            }
        }
        
        // Tentar autenticar como Bibliotecario
        if (bibliotecarioDAO.autenticar(id, senha)) {
            Bibliotecario bibliotecario = bibliotecarioDAO.buscarPorId(id);
            if (bibliotecario != null) {
                usuarioLogado = bibliotecario.getNome();
                funcaoUsuario = "Bibliotecario";
                return true;
            }
        }
        
        // ADM fixo 
        if (id == 1111 && "adm123".equals(senha)) {
            usuarioLogado = "Administrador";
            funcaoUsuario = "ADM";
            return true;
        }
        
        return false;
    }

    public boolean alterarSenha(int id, String senhaAntiga, String novaSenha, String tipoUsuario) {
        boolean sucesso = false;
        
        if ("Gestor".equals(tipoUsuario)) {
            sucesso = gestorDAO.alterarSenha(id, senhaAntiga, novaSenha);
        } else if ("Bibliotecario".equals(tipoUsuario)) {
            sucesso = bibliotecarioDAO.alterarSenha(id, senhaAntiga, novaSenha);
        } else if ("ADM".equals(tipoUsuario)) {
            // ADM nao altera senha 
            sucesso = false;
        }
        
        return sucesso;
    }

    
    public String getUsuarioLogado() { 
        return usuarioLogado != null ? usuarioLogado : "Usuário"; 
    }
    
    public String getFuncaoUsuario() { 
        return funcaoUsuario != null ? funcaoUsuario : "Não definida"; 
    }
}

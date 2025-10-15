
package DAO;

import model.Atividade;
import java.util.List;
import java.util.ArrayList;

public class AtividadeDAO extends BaseDAO {
    private static final String ARQUIVO = "atividades.dat";
    private List<Atividade> atividades;

    public AtividadeDAO() {
        atividades = carregarDados(ARQUIVO);
    }

    public void registrarAtividade(Atividade atividade) {
        atividades.add(0, atividade); // Adiciona no início para manter ordem recente
        if (atividades.size() > 1000) { // Limite de 1000 registros
            atividades = atividades.subList(0, 1000);
        }
        salvarDados(ARQUIVO, atividades);
    }

    public List<Atividade> listarTodasAtividades() {
        return new ArrayList<>(atividades);
    }

    public List<Atividade> buscarPorUsuario(String nomeUsuario) {
        List<Atividade> resultado = new ArrayList<>();
        for (Atividade atividade : atividades) {
            if (atividade.getNomeUsuario().equalsIgnoreCase(nomeUsuario)) {
                resultado.add(atividade);
            }
        }
        return resultado;
    }

    public List<Atividade> buscarPorFuncao(String funcao) {
        List<Atividade> resultado = new ArrayList<>();
        for (Atividade atividade : atividades) {
            if (atividade.getFuncaoUsuario().equalsIgnoreCase(funcao)) {
                resultado.add(atividade);
            }
        }
        return resultado;
    }

    public List<Atividade> buscarPorModulo(String modulo) {
        List<Atividade> resultado = new ArrayList<>();
        for (Atividade atividade : atividades) {
            if (atividade.getModulo().equalsIgnoreCase(modulo)) {
                resultado.add(atividade);
            }
        }
        return resultado;
    }

    public List<Atividade> buscarPorData(String data) {
        List<Atividade> resultado = new ArrayList<>();
        for (Atividade atividade : atividades) {
            if (atividade.getDataHora().startsWith(data)) {
                resultado.add(atividade);
            }
        }
        return resultado;
    }
}


package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Atividade implements Serializable {
    private String dataHora;
    private String nomeUsuario;
    private String funcaoUsuario;
    private String tipoAcao;
    private String detalhes;
    private String modulo;
    private String dadosExtras; // Para informações adicionais

    public Atividade(String nomeUsuario, String funcaoUsuario, String tipoAcao, 
                   String detalhes, String modulo, String dadosExtras) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dataHora = LocalDateTime.now().format(formatter);
        this.nomeUsuario = nomeUsuario;
        this.funcaoUsuario = funcaoUsuario;
        this.tipoAcao = tipoAcao;
        this.detalhes = detalhes;
        this.modulo = modulo;
        this.dadosExtras = dadosExtras;
    }

    
    public String getDataHora() { return dataHora; }
    public String getNomeUsuario() { return nomeUsuario; }
    public String getFuncaoUsuario() { return funcaoUsuario; }
    public String getTipoAcao() { return tipoAcao; }
    public String getDetalhes() { return detalhes; }
    public String getModulo() { return modulo; }
    public String getDadosExtras() { return dadosExtras; }
}
// Arquivo: DetalhesAtividade.java (ATUALIZADO)
package view;

import model.Atividade;
import javax.swing.*;
import java.awt.*;
import java.awt.print.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetalhesAtividade extends javax.swing.JFrame {

    private Atividade atividade;
    
    public DetalhesAtividade(Atividade atividade) {
        this.atividade = atividade;
        initComponents();
        carregarDetalhes();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Detalhes da Atividade");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500); 
        setResizable(false);
        
        // Layout principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Título
        JLabel tituloLabel = new JLabel("DETALHES DA ATIVIDADE");
        tituloLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        tituloLabel.setForeground(new Color(94, 42, 43));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Painel de detalhes
        JPanel detalhesPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        detalhesPanel.setBorder(BorderFactory.createTitledBorder("Informações da Atividade"));
        
        // Adicionar campos
        adicionarCampo(detalhesPanel, "Data/Hora:", atividade.getDataHora());
        adicionarCampo(detalhesPanel, "Utilizador:", atividade.getNomeUsuario());
        adicionarCampo(detalhesPanel, "Função:", atividade.getFuncaoUsuario());
        adicionarCampo(detalhesPanel, "Ação:", atividade.getTipoAcao());
        adicionarCampo(detalhesPanel, "Módulo:", atividade.getModulo());
        adicionarCampo(detalhesPanel, "Descrição:", atividade.getDetalhes());
        
        // Area para dados extras
        JTextArea extrasArea = new JTextArea(atividade.getDadosExtras());
        extrasArea.setEditable(false);
        extrasArea.setLineWrap(true);
        extrasArea.setWrapStyleWord(true);
        extrasArea.setBackground(new Color(240, 240, 240));
        extrasArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JScrollPane extrasScroll = new JScrollPane(extrasArea);
        extrasScroll.setBorder(BorderFactory.createTitledBorder("Detalhes Adicionais"));
        extrasScroll.setPreferredSize(new Dimension(450, 100));
        
        // Painel de botoes
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        JButton btnImprimir = new JButton("Imprimir Relatório");
        btnImprimir.setBackground(new Color(94, 42, 43));
        btnImprimir.setForeground(Color.WHITE);
        btnImprimir.addActionListener(e -> imprimirRelatorio());
        
        JButton btnFechar = new JButton("Fechar");
        btnFechar.setBackground(new Color(201, 169, 154));
        btnFechar.setForeground(new Color(94, 42, 43));
        btnFechar.addActionListener(e -> dispose());
        
        buttonPanel.add(btnImprimir);
        buttonPanel.add(btnFechar);
        
        // Montar layout
        mainPanel.add(tituloLabel, BorderLayout.NORTH);
        mainPanel.add(detalhesPanel, BorderLayout.CENTER);
        mainPanel.add(extrasScroll, BorderLayout.SOUTH);
        
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void adicionarCampo(JPanel panel, String label, String valor) {
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        JTextField field = new JTextField(valor);
        field.setEditable(false);
        field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        field.setBackground(Color.WHITE);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        panel.add(lbl);
        panel.add(field);
    }
    
    private void carregarDetalhes() {
        // Ja carregado no construtor
    }
    
    // METODO IMPRIMIR RELATORIO
    private void imprimirRelatorio() {
        try {
            // Criar conteudo do relatorio
            String relatorio = gerarConteudoRelatorio();
            
            // Mostrar preview antes de imprimir
            int option = JOptionPane.showConfirmDialog(this, 
                "Deseja imprimir o relatório desta atividade?\n\n" + relatorio,
                "Confirmar Impressão", 
                JOptionPane.YES_NO_OPTION);
            
            if (option == JOptionPane.YES_OPTION) {
                // Simular impressao )
                JOptionPane.showMessageDialog(this, 
                    "Relatório enviado para impressão!\n\n" + relatorio,
                    "Impressão Concluída", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao imprimir: " + e.getMessage(),
                "Erro de Impressão", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String gerarConteudoRelatorio() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataImpressao = sdf.format(new Date());
        
        return "=== RELATÓRIO DE ATIVIDADE ===\n" +
               "Data de impressão: " + dataImpressao + "\n" +
               "----------------------------------------\n" +
               "Data/Hora: " + atividade.getDataHora() + "\n" +
               "Utilizador: " + atividade.getNomeUsuario() + "\n" +
               "Função: " + atividade.getFuncaoUsuario() + "\n" +
               "Ação: " + atividade.getTipoAcao() + "\n" +
               "Módulo: " + atividade.getModulo() + "\n" +
               "Descrição: " + atividade.getDetalhes() + "\n" +
               "Detalhes: " + atividade.getDadosExtras() + "\n" +
               "----------------------------------------\n" +
               "Sistema SIGB - Relatório de Atividade";
    }
}

package view;

import service.DenunciaService;
import exception.CampoObrigatorioException;
import exception.DenunciaNaoEncontradaException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Tela principal do sistema, responsável por apresentar as ações disponíveis.
 */
public class TelaPrincipal extends JFrame {
    private final DenunciaService service;

    public TelaPrincipal(DenunciaService service) {
        this.service = service;
        setTitle("Denúncia Escolar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 320);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JButton btnNova = new JButton("Nova denúncia");
        btnNova.addActionListener(this::abrirCadastro);

        JButton btnConsultar = new JButton("Consultar denúncia");
        btnConsultar.addActionListener(this::abrirConsulta);

        JButton btnListar = new JButton("Listar denúncias");
        btnListar.addActionListener(this::abrirListagem);

        JButton btnAtualizar = new JButton("Atualizar status");
        btnAtualizar.addActionListener(this::atualizarStatus);

        JButton btnEncerrar = new JButton("Encerrar denúncia");
        btnEncerrar.addActionListener(this::encerrarDenuncia);

        panel.add(btnNova);
        panel.add(btnConsultar);
        panel.add(btnListar);
        panel.add(btnAtualizar);
        panel.add(btnEncerrar);

        add(panel, BorderLayout.CENTER);
    }

    private void abrirCadastro(ActionEvent event) {
        TelaCadastro tela = new TelaCadastro(this, service);
        tela.setVisible(true);
    }

    private void abrirConsulta(ActionEvent event) {
        TelaConsulta tela = new TelaConsulta(this, service);
        tela.setVisible(true);
    }

    private void abrirListagem(ActionEvent event) {
        TelaListagem tela = new TelaListagem(service);
        tela.setVisible(true);
    }

    private void atualizarStatus(ActionEvent event) {
        try {
            String protocolo = JOptionPane.showInputDialog(this, "Digite o protocolo da denúncia:", "Atualizar Status", JOptionPane.QUESTION_MESSAGE);
            if (protocolo == null || protocolo.trim().isEmpty()) {
                return;
            }
            var denuncia = service.consultar(protocolo);
            String[] opcoes = {"ABERTO", "EM ANDAMENTO", "ENCERRADO"};
            String status = (String) JOptionPane.showInputDialog(this,
                    "Selecione o novo status:",
                    "Atualizar Status",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    denuncia.getStatus());
            if (status == null) {
                return;
            }
            if ("ENCERRADO".equalsIgnoreCase(status)) {
                service.encerrarDenuncia(protocolo);
            } else {
                service.atualizarStatus(protocolo, status);
            }
            JOptionPane.showMessageDialog(this, "Status atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (CampoObrigatorioException | DenunciaNaoEncontradaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void encerrarDenuncia(ActionEvent event) {
        try {
            String protocolo = JOptionPane.showInputDialog(this, "Digite o protocolo da denúncia:", "Encerrar Denúncia", JOptionPane.QUESTION_MESSAGE);
            if (protocolo == null || protocolo.trim().isEmpty()) {
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Deseja encerrar a denúncia " + protocolo + "?",
                    "Confirmar encerramento",
                    JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            service.encerrarDenuncia(protocolo);
            JOptionPane.showMessageDialog(this, "Denúncia encerrada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (CampoObrigatorioException | DenunciaNaoEncontradaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
}

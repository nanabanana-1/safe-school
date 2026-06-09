package view;

import exception.CampoObrigatorioException;
import exception.DenunciaNaoEncontradaException;
import model.Denuncia;
import service.DenunciaService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Tela que permite consultar uma denúncia pelo protocolo.
 */
public class TelaConsulta extends JDialog {
    private final DenunciaService service;
    private JTextField protocoloField;
    private JTextArea resultadoArea;

    public TelaConsulta(Frame owner, DenunciaService service) {
        super(owner, "Consultar denúncia", true);
        this.service = service;
        setSize(520, 320);
        setLocationRelativeTo(owner);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JPanel topPanel = new JPanel(new BorderLayout(8, 8));
        topPanel.add(new JLabel("Protocolo:"), BorderLayout.WEST);
        protocoloField = new JTextField();
        topPanel.add(protocoloField, BorderLayout.CENTER);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this::buscarDenuncia);
        topPanel.add(btnBuscar, BorderLayout.EAST);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(resultadoArea);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        add(panel);
    }

    private void buscarDenuncia(ActionEvent event) {
        try {
            String protocolo = protocoloField.getText();
            Denuncia denuncia = service.consultar(protocolo);
            String mensagem = montarDetalhes(denuncia);
            resultadoArea.setText(mensagem);
        } catch (CampoObrigatorioException | DenunciaNaoEncontradaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    private String montarDetalhes(Denuncia denuncia) {
        return "Protocolo: " + denuncia.getProtocolo() + "\n"
                + "Tipo: " + obterTipo(denuncia) + "\n"
                + "Status: " + denuncia.getStatus() + "\n"
                + "Data: " + denuncia.getData() + "\n"
                + "Local: " + denuncia.getLocal() + "\n\n"
                + "Resumo: " + denuncia.gerarResumo();
    }

    private String obterTipo(Denuncia denuncia) {
        String nome = denuncia.getClass().getSimpleName();
        return nome.replace("Denuncia", "");
    }
}

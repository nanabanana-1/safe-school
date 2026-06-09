package view;

import exception.CampoObrigatorioException;
import exception.ProtocoloDuplicadoException;
import model.Denuncia;
import model.DenunciaAssedio;
import model.DenunciaBullying;
import model.DenunciaDiscriminacao;
import model.DenunciaVandalismo;
import service.DenunciaService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

/**
 * Tela responsável pelo cadastro de novas denúncias.
 */
public class TelaCadastro extends JDialog {
    private final DenunciaService service;
    private JComboBox<String> tipoCombo;
    private JTextArea descricaoArea;
    private JTextField localField;
    private JTextField dataField;

    public TelaCadastro(Frame owner, DenunciaService service) {
        super(owner, "Nova Denúncia", true);
        this.service = service;
        setSize(520, 420);
        setLocationRelativeTo(owner);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        form.add(new JLabel("Tipo de denúncia:"), gbc);

        tipoCombo = new JComboBox<>(new String[]{"Selecione", "Bullying", "Assédio", "Discriminação", "Vandalismo"});
        gbc.gridy = 1;
        form.add(tipoCombo, gbc);

        gbc.gridy = 2;
        form.add(new JLabel("Descrição:"), gbc);

        descricaoArea = new JTextArea(6, 30);
        descricaoArea.setLineWrap(true);
        descricaoArea.setWrapStyleWord(true);
        JScrollPane scrollDescricao = new JScrollPane(descricaoArea);
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        form.add(scrollDescricao, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 4;
        form.add(new JLabel("Local:"), gbc);

        localField = new JTextField();
        gbc.gridy = 5;
        form.add(localField, gbc);

        gbc.gridy = 6;
        form.add(new JLabel("Data:"), gbc);

        dataField = new JTextField(LocalDate.now().toString());
        gbc.gridy = 7;
        form.add(dataField, gbc);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(this::registrarDenuncia);

        panel.add(form, BorderLayout.CENTER);
        panel.add(btnRegistrar, BorderLayout.SOUTH);
        add(panel);
    }

    private void registrarDenuncia(ActionEvent event) {
        try {
            String tipo = (String) tipoCombo.getSelectedItem();
            Denuncia denuncia = criarDenuncia(tipo);
            denuncia.setDescricao(descricaoArea.getText());
            denuncia.setLocal(localField.getText());
            String dataInformada = dataField.getText();
            if (dataInformada == null || dataInformada.trim().isEmpty()) {
                dataInformada = LocalDate.now().toString();
            }
            denuncia.setData(dataInformada.trim());

            String protocolo = service.cadastrar(denuncia);
            String mensagem = "Obrigada por denunciar! 💜\n\n"
                    + "Você não está sozinho ( ˘͈ ᵕ ˘͈♡ )\n\n"
                    + "Sua denúncia foi registrada com sucesso.\n"
                    + "Protocolo: " + protocolo + "\n\n"
                    + "Juntos podemos tornar a escola um lugar mais seguro.";
            JOptionPane.showMessageDialog(this, mensagem, "Denúncia registrada", JOptionPane.INFORMATION_MESSAGE);
            limparFormulario();
        } catch (CampoObrigatorioException | ProtocoloDuplicadoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    private Denuncia criarDenuncia(String tipo) {
        if (tipo == null || "Selecione".equals(tipo)) {
            throw new IllegalArgumentException("Tipo da denúncia é obrigatório.");
        }
        return switch (tipo) {
            case "Bullying" -> new DenunciaBullying();
            case "Assédio" -> new DenunciaAssedio();
            case "Discriminação" -> new DenunciaDiscriminacao();
            case "Vandalismo" -> new DenunciaVandalismo();
            default -> throw new IllegalArgumentException("Tipo de denúncia inválido.");
        };
    }

    private void limparFormulario() {
        tipoCombo.setSelectedIndex(0);
        descricaoArea.setText("");
        localField.setText("");
        dataField.setText(LocalDate.now().toString());
    }
}

package view;

import model.Denuncia;
import service.DenunciaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Tela que exibe todas as denúncias cadastradas em forma de tabela.
 */
public class TelaListagem extends JFrame {
    private final DenunciaService service;
    private final DefaultTableModel tableModel;

    public TelaListagem(DenunciaService service) {
        this.service = service;
        setTitle("Listagem de denúncias");
        setSize(720, 340);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tableModel = new DefaultTableModel(new Object[]{"Protocolo", "Tipo", "Local", "Data", "Status"}, 0);
        initComponents();
        carregarDenuncias();
    }

    private void initComponents() {
        JTable tabela = new JTable(tableModel);
        tabela.setEnabled(false);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);
    }

    private void carregarDenuncias() {
        tableModel.setRowCount(0);
        List<Denuncia> denuncias = service.listar();
        for (Denuncia denuncia : denuncias) {
            tableModel.addRow(new Object[]{
                    denuncia.getProtocolo(),
                    denuncia.getClass().getSimpleName().replace("Denuncia", ""),
                    denuncia.getLocal(),
                    denuncia.getData(),
                    denuncia.getStatus()
            });
        }
    }
}

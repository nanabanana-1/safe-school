package view;

import service.DenunciaService;

import javax.swing.*;

/**
 * Classe de entrada da aplicação.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DenunciaService service = new DenunciaService();
            TelaPrincipal principal = new TelaPrincipal(service);
            principal.setVisible(true);
        });
    }
}

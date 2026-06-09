package exception;

/**
 * Exceção disparada quando um campo obrigatório não foi preenchido.
 */
public class CampoObrigatorioException extends Exception {
    public CampoObrigatorioException(String message) {
        super(message);
    }
}

package exception;

/**
 * Exceção disparada quando a denúncia pesquisada não existe.
 */
public class DenunciaNaoEncontradaException extends Exception {
    public DenunciaNaoEncontradaException(String message) {
        super(message);
    }
}

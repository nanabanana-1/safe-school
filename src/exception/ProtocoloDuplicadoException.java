package exception;

/**
 * Exceção disparada quando há tentativa de registrar um protocolo duplicado.
 */
public class ProtocoloDuplicadoException extends Exception {
    public ProtocoloDuplicadoException(String message) {
        super(message);
    }
}

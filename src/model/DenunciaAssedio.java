package model;

/**
 * Denúncia do tipo Assédio.
 */
public class DenunciaAssedio extends Denuncia {
    @Override
    public String gerarResumo() {
        return "Assédio - " + getDescricao();
    }
}

package model;

/**
 * Denúncia do tipo Vandalismo.
 */
public class DenunciaVandalismo extends Denuncia {
    @Override
    public String gerarResumo() {
        return "Vandalismo - " + getDescricao();
    }
}

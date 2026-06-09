package model;

/**
 * Denúncia do tipo Discriminação.
 */
public class DenunciaDiscriminacao extends Denuncia {
    @Override
    public String gerarResumo() {
        return "Discriminação - " + getDescricao();
    }
}

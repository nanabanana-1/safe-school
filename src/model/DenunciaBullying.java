package model;

/**
 * Denúncia do tipo Bullying.
 */
public class DenunciaBullying extends Denuncia {
    @Override
    public String gerarResumo() {
        return "Bullying - " + getDescricao();
    }
}

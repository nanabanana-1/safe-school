package model;

/**
 * Classe abstrata que representa uma denúncia genérica.
 * Define os atributos comuns e força a implementação de gerarResumo().
 */
public abstract class Denuncia {
    private String protocolo;
    private String descricao;
    private String local;
    private String data;
    private String status;

    public Denuncia() {
        this.status = "ABERTO";
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método abstrato que cada subclasse deve implementar retornando um resumo específico
    public abstract String gerarResumo();
}

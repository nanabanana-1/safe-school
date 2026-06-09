package service;

import exception.CampoObrigatorioException;
import exception.DenunciaNaoEncontradaException;
import exception.ProtocoloDuplicadoException;
import model.Denuncia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço responsável pela gestão de denúncias em memória.
 * Mantém uma lista de denúncias e implementa regras de negócio.
 */
public class DenunciaService {
    private final List<Denuncia> denuncias = new ArrayList<>();
    private int contadorProtocolo = 1;

    public String cadastrar(Denuncia denuncia) throws CampoObrigatorioException, ProtocoloDuplicadoException {
        validarDenuncia(denuncia);
        String protocolo = gerarProtocolo();
        if (existeProtocolo(protocolo)) {
            throw new ProtocoloDuplicadoException("Falha ao gerar protocolo. Tente novamente.");
        }
        denuncia.setProtocolo(protocolo);
        denuncia.setStatus("ABERTO");
        denuncias.add(denuncia);
        return protocolo;
    }

    public Denuncia consultar(String protocolo) throws CampoObrigatorioException, DenunciaNaoEncontradaException {
        if (protocolo == null || protocolo.trim().isEmpty()) {
            throw new CampoObrigatorioException("Protocolo é obrigatório para consulta.");
        }
        return denuncias.stream()
                .filter(d -> d.getProtocolo().equalsIgnoreCase(protocolo.trim()))
                .findFirst()
                .orElseThrow(() -> new DenunciaNaoEncontradaException("Denúncia não encontrada para o protocolo informado."));
    }

    public List<Denuncia> listar() {
        return new ArrayList<>(denuncias);
    }

    public void atualizarStatus(String protocolo, String novoStatus) throws CampoObrigatorioException, DenunciaNaoEncontradaException {
        Denuncia denuncia = consultar(protocolo);
        if ("ENCERRADO".equalsIgnoreCase(denuncia.getStatus())) {
            throw new IllegalStateException("Não é possível alterar uma denúncia encerrada.");
        }
        if (novoStatus == null || novoStatus.trim().isEmpty()) {
            throw new CampoObrigatorioException("Informe o novo status da denúncia.");
        }
        denuncia.setStatus(novoStatus.trim().toUpperCase());
    }

    public void encerrarDenuncia(String protocolo) throws CampoObrigatorioException, DenunciaNaoEncontradaException {
        Denuncia denuncia = consultar(protocolo);
        if ("ENCERRADO".equalsIgnoreCase(denuncia.getStatus())) {
            throw new IllegalStateException("A denúncia já está encerrada.");
        }
        denuncia.setStatus("ENCERRADO");
    }

    private void validarDenuncia(Denuncia denuncia) throws CampoObrigatorioException {
        if (denuncia == null) {
            throw new CampoObrigatorioException("Denúncia inválida. Selecione um tipo de denúncia.");
        }
        if (denuncia.getDescricao() == null || denuncia.getDescricao().trim().isEmpty()) {
            throw new CampoObrigatorioException("Descrição é obrigatória.");
        }
        if (denuncia.getDescricao().trim().length() < 20) {
            throw new CampoObrigatorioException("A descrição deve conter pelo menos 20 caracteres.");
        }
    }

    private boolean existeProtocolo(String protocolo) {
        return denuncias.stream().anyMatch(d -> d.getProtocolo().equalsIgnoreCase(protocolo));
    }

    private String gerarProtocolo() {
        String ano = String.valueOf(LocalDate.now().getYear());
        String protocolo;
        do {
            protocolo = String.format("D%s-%03d", ano, contadorProtocolo++);
        } while (existeProtocolo(protocolo));
        return protocolo;
    }
}

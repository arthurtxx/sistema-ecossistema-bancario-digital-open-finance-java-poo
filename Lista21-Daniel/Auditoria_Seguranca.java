
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Auditoria_Seguranca {
    private List<String> registros;
    public Auditoria_Seguranca() {
        registros = new ArrayList<>();
    }

    public void registrar(String descricao) {
        String registro = LocalDateTime.now() + " - " + descricao;
        registros.add(registro);
        System.out.println("Esta auditoria registrada: " + descricao);
    }

    public void registrarAcessoSuspeito(String usuario) {
        registrar("Este acesso suspeito: " + usuario);
    }

    public void registrarBloqueio(String usuario) {
        registrar("Usuario bloqueado: " + usuario);
    }

    public void exibirRelatorio() {
        System.out.println("\n===== RELATORIO DE AUDITORIA =====");

        for (String registro : registros) {
            System.out.println(registro);
        }
    }

    public List<String> getRegistros() {
        return new ArrayList<>(registros);
    }
}
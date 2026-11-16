
import java.time.LocalDateTime;

public class Transacao {
    private String codigoTransacao;
    private LocalDateTime dataHora;
    private double valor;
    private String descricao;

    public Transacao(
        String codigoTransacao,
        double valor,
        String descricao) {

        this.codigoTransacao = codigoTransacao;
        this.dataHora = LocalDateTime.now();
        this.valor = valor;
        this.descricao = descricao;
    }

    public void exibirDados() {
        System.out.println("\nCodigo: " + codigoTransacao);
        System.out.println("Data: " + dataHora);
        System.out.println("Valor e de: R$ " + valor);
        System.out.println("Descricao: " + descricao);
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
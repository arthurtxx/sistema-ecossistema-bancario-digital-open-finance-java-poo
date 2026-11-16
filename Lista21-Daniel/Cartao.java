
import java.time.LocalDate;

public abstract class Cartao {
    private String numeroCartao;
    private String nomeImpresso;
    private String cvv;
    private LocalDate validade;
    private boolean ativo;

    public Cartao(
        String numeroCartao,
        String nomeImpresso,
        String cvv,
        LocalDate validade) {

        this.numeroCartao = numeroCartao;
        this.nomeImpresso = nomeImpresso;
        this.cvv = cvv;
        this.validade = validade;
        this.ativo = true;
    }

    public void bloquear() {
        ativo = false;
        System.out.println("Cartao bloqueado troxa");
    }

    public void desbloquear() {
        ativo = true;
        System.out.println("Cartao desbloqueado");
    }

    public boolean isAtivo() {
        return ativo && !validade.isBefore(LocalDate.now());
    }

    public abstract void realizarPagamento(
        double valor, String senha);

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public LocalDate getValidade() {
        return validade;
    }
}
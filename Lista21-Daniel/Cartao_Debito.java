import java.time.LocalDate;

public class Cartao_Debito extends Cartao {
    private Conta_Bancaria conta;

    public Cartao_Debito(
        String numeroCartao,
        String nomeImpresso,
        String cvv,
        LocalDate validade,
        Conta_Bancaria conta) {

        super(numeroCartao, nomeImpresso, cvv, validade);
        this.conta = conta;
    }

    @Override
    public void realizarPagamento(double valor, String senha) {
        if (!isAtivo()) {
            System.out.println("Cartao bloqueado ou vencido");
            return;
        }

        if (valor <= 0) {
            System.out.println("Valor invalido");
            return;
        }

        if (conta.sacar(valor, senha)) {
            System.out.println("Compra no debito aprovada: R$ " + valor);
        } else {
            System.out.println("Compra recusada: saldo insuficiente ou senha invalida");
        }
    }

    public Conta_Bancaria getConta() {
        return conta;
    }
}
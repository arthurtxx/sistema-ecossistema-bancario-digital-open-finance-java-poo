import java.time.LocalDate;

public class Cartao_Credito extends Cartao {
    private double limiteTotal;
    private double limiteDisponivel;
    private double faturaAtual;
    private int melhorDiaCompra;

    public Cartao_Credito(
        String numeroCartao,
        String nomeImpresso,
        String cvv,
        LocalDate validade,
        double limiteTotal,
        int melhorDiaCompra) {

        super(numeroCartao, nomeImpresso, cvv, validade);
        this.limiteTotal = limiteTotal;
        this.limiteDisponivel = limiteTotal;
        this.faturaAtual = 0;
        this.melhorDiaCompra = melhorDiaCompra;
    }

    @Override
    public void realizarPagamento(double valor, String senha) {
        // No credito a senha nao e usada, mas precisa estar na assinatura
        if (!isAtivo()) {
            System.out.println("Cartao bloqueado ou vencido");
            return;
        }

        if (valor <= 0) {
            System.out.println("Valor invalido");
            return;
        }

        if (valor > limiteDisponivel) {
            System.out.println("Compra recusada: limite insuficiente");
            return;
        }

        limiteDisponivel -= valor;
        faturaAtual += valor;
        System.out.println("Compra no credito aprovada: R$ " + valor);
    }

    public void pagarFatura(double valor) {
        if (valor <= 0) {
            System.out.println("Valor invalido");
            return;
        }

        if (valor > faturaAtual) {
            valor = faturaAtual;
        }

        faturaAtual -= valor;
        limiteDisponivel += valor;

        if (limiteDisponivel > limiteTotal) {
            limiteDisponivel = limiteTotal;
        }

        System.out.println("Fatura paga: R$ " + valor);
    }

    public double getLimiteTotal() {
        return limiteTotal;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public double getFaturaAtual() {
        return faturaAtual;
    }

    public int getMelhorDiaCompra() {
        return melhorDiaCompra;
    }
}
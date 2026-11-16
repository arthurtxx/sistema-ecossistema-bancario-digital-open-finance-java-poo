
public class Conta_Investimento extends Conta_Bancaria {
    private String perfilRisco;
    private double taxaCorretagem;

    public Conta_Investimento(
        int agencia,
        String numeroConta,
        double saldo,
        String senha,
        Cliente titular,
        String perfilRisco,
        double taxaCorretagem) {

        super(agencia, numeroConta, saldo, senha, titular);
        this.perfilRisco = perfilRisco;
        this.taxaCorretagem = taxaCorretagem;
    }

    @Override
    public String getTipoConta() {
        return "Conta Investimento";
    }

    public void investir(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de investimento invalido");
        } else if (valor + taxaCorretagem > saldo) {
            System.out.println("Saldo insuficiente para investir");
        } else {
            saldo -= valor + taxaCorretagem;

            System.out.println("Investimento realizado com sucesso");
        }
    }

    public String getPerfilRisco() {
        return perfilRisco;
    }

    public double getTaxaCorretagem() {
        return taxaCorretagem;
    }
}
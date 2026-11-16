
public class Conta_Poupanca extends Conta_Bancaria {
    private double taxaRendimentoDiario;
    private int aniversarioPoupanca;

    public Conta_Poupanca(
        int agencia,
        String numeroConta,
        double saldo,
        String senha,
        Cliente titular,
        double taxaRendimentoDiario,
        int aniversarioPoupanca) {

        super(agencia, numeroConta, saldo, senha, titular);
        this.taxaRendimentoDiario = taxaRendimentoDiario;
        this.aniversarioPoupanca = aniversarioPoupanca;
    }

    @Override
    public String getTipoConta() {
        return "Conta Poupanca";
    }

    public void aplicarRendimento() {
        if (taxaRendimentoDiario < 0) {
            System.out.println("Taxa de rendimento invalida.");
            return;
        }

        double rendimento = saldo * taxaRendimentoDiario;

        saldo += rendimento;
        System.out.println("Rendimento aplicado: R$ " + rendimento);
    }

    public double getTaxaRendimentoDiario() {
        return taxaRendimentoDiario;
    }

    public int getAniversarioPoupanca() {
        return aniversarioPoupanca;
    }
}
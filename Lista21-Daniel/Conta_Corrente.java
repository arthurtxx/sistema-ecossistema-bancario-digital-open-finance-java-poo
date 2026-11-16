
public class Conta_Corrente extends Conta_Bancaria {
    private double limiteChequeEspecial;
    private double taxaManutencao;

    public Conta_Corrente(
        int agencia,
        String numeroConta,
        double saldo,
        String senha,
        Cliente titular,
        double limiteChequeEspecial,
        double taxaManutencao) {

        super(agencia, numeroConta, saldo, senha, titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public boolean sacar(double valor, String senhaInformada) {

        if (!autenticar(senhaInformada)) {
            System.out.println("Senha incorreta");
            return false;
        }

        if (valor <= 0 || valor > saldo + limiteChequeEspecial) {
            System.out.println("Saldo e limite insuficientes");
            return false;
        }

        saldo -= valor;
        System.out.println("Saque realizado na conta corrente");
        return true;
    }

    @Override
    public String getTipoConta() {
        return "Conta Corrente";
    }

    public void cobrarManutencao() {
        if (taxaManutencao > 0 && saldo >= taxaManutencao) {
            saldo -= taxaManutencao;
            System.out.println("Taxa de manutencao cobrada");
        } else {
            System.out.println("Saldo insuficiente para manutencao...pobre");
        }
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }
}
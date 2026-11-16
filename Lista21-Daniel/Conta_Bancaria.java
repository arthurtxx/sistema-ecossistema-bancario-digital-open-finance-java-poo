
public abstract class Conta_Bancaria {
    private int agencia;
    private String numeroConta;
    protected double saldo;
    private String senha;
    private Cliente titular;

    public Conta_Bancaria(
        int agencia,
        String numeroConta,
        double saldo,
        String senha,
        Cliente titular) {

        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo inicial invalido");
        }

        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.senha = senha;
        this.titular = titular;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de deposito invalido");
            return false;
        }

        saldo += valor;

        System.out.println("Deposito realizado com sucesso");
        return true;
    }

    public boolean sacar(double valor, String senhaInformada) {

        if (!autenticar(senhaInformada)) {
            System.out.println("Senha incorreta");
            return false;
        }

        if (valor <= 0 || valor > saldo) {
            System.out.println("Saldo insuficiente ou valor invalido");
            return false;
        }

        saldo -= valor;

        System.out.println("Saque realizado com sucesso");
        return true;
    }

    public boolean autenticar(String senhaInformada) {
        return senha.equals(senhaInformada);
    }

    public abstract String getTipoConta();

    public int getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }
}
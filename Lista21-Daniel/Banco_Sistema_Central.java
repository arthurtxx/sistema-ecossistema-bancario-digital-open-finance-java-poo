
import java.util.ArrayList;
import java.util.List;

public class Banco_Sistema_Central {
    private List<Cliente> clientes;
    private List<Conta_Bancaria> contas;
    private List<Cartao> cartoes;
    private List<Transacao> transacoes;
    private List<Emprestimo_Financiamento> emprestimos;
    private Auditoria_Seguranca auditoria;

    public Banco_Sistema_Central() {
        clientes = new ArrayList<>();
        contas = new ArrayList<>();
        cartoes = new ArrayList<>();
        transacoes = new ArrayList<>();
        emprestimos = new ArrayList<>();
        auditoria = new Auditoria_Seguranca();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        auditoria.registrar(
            "Cliente cadastrado: " + cliente.getNome()
        );
    }

    public void abrirConta(Conta_Bancaria conta) {
        contas.add(conta);

        auditoria.registrar(
            "Conta aberta: " + conta.getNumeroConta()
        );
    }

    public void emitirCartao(Cartao cartao) {
        cartoes.add(cartao);

        auditoria.registrar(
            "Cartao emitido: " + cartao.getNomeImpresso()
        );
    }

    public void registrarEmprestimo(
        Emprestimo_Financiamento emprestimo) {

        emprestimos.add(emprestimo);
    }

    public void depositar(Conta_Bancaria conta, double valor) {

        if (conta.depositar(valor)) {
            transacoes.add(new Transacao(
                "DEP" + System.currentTimeMillis(),
                valor,
                "Deposito bancario"
            ));
        }
    }

    public void sacar(
        Conta_Bancaria conta, double valor, String senha) {

        if (conta.sacar(valor, senha)) {
            transacoes.add(new Transacao(
                "SAQ" + System.currentTimeMillis(),
                valor,
                "Saque bancario"
            ));
        }
    }

    public void transferir(
        Conta_Bancaria origem,
        Conta_Bancaria destino,
        double valor,
        String senha) {

        if (origem == destino) {
            System.out.println("Nao e possivel transferir para a mesma conta");
            return;
        }

        if (origem.sacar(valor, senha)) {
            destino.depositar(valor);
            transacoes.add(new Transacao(
                "PIX" + System.currentTimeMillis(),
                valor,
                "Transferencia PIX"
            ));

            auditoria.registrar("Transferencia realizada com sucesso");
        }
    }

    public void exibirExtrato() {
        System.out.println("\n===== EXTRATO BANCARIO =====");

        for (Transacao transacao : transacoes) {
            transacao.exibirDados();
        }
    }

    public void exibirContas() {
        System.out.println("\n===== CONTAS CADASTRADAS =====");

        for (Conta_Bancaria conta : contas) {
            System.out.println(
                conta.getTipoConta() +
                " - " + conta.getNumeroConta() +
                " - Saldo e: R$ " + conta.getSaldo()
            );
        }
    }

    public void exibirClientes() {
        System.out.println("\n===== CLIENTES =====");

        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome());
        }
    }

    public void exibirAuditoria() {
        auditoria.exibirRelatorio();
    }

    public Auditoria_Seguranca getAuditoria() {
        return auditoria;
    }
}
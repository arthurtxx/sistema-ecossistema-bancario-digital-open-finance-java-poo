import java.time.LocalDate;

public class Programa {
    public static void main(String[] args) {
        Banco_Sistema_Central banco =
            new Banco_Sistema_Central();
        System.out.println("==================================");
        System.out.println("        BANCO DIGITAL JAVA");
        System.out.println("==================================");

        Cliente_Pessoa_Fisica cliente1 =
            new Cliente_Pessoa_Fisica(
                1,
                "Arthur Braga",
                "70436474603",
                "Contagem MG",
                "Médio",
                "03/03/2006",
                7650,
                "Casado"
            );

        Cliente_Pessoa_Juridica cliente2 =
            new Cliente_Pessoa_Juridica(
                2,
                "Onfly",
                "30.342.266/0001-83",
                "Belo Horizonte MG",
                "Alto",
                120000,
                "Onfly",
                "Tecnologia"
            );

        banco.cadastrarCliente(cliente1);
        banco.cadastrarCliente(cliente2);

        Conta_Corrente conta1 = new Conta_Corrente(
            1234, "10001", 2000, "123",
            cliente1, 1000, 20
        );

        Conta_Poupanca conta2 = new Conta_Poupanca(
            1234, "10002", 1000, "456",
            cliente1, 0.001, 10
        );

        Conta_Investimento conta3 = new Conta_Investimento(
            1234, "10003", 5000, "789",
            cliente2, "Moderado", 10
        );

        banco.abrirConta(conta1);
        banco.abrirConta(conta2);
        banco.abrirConta(conta3);

        Cartao_Debito cartao1 = new Cartao_Debito(
            "1111222233336767",
            "ARTHUR BRAGA",
            "123",
            LocalDate.of(2030, 12, 31),
            conta1
        );

        Cartao_Credito cartao2 = new Cartao_Credito(
            "5555666677778888",
            "ARTHUR BRAGA",
            "456",
            LocalDate.of(2030, 12, 31),
            3000,
            10
        );

        banco.emitirCartao(cartao1);
        banco.emitirCartao(cartao2);

        System.out.println("\n===== OPERACOES =====");

        banco.depositar(conta1, 500);

        banco.sacar(conta1, 200, "123");

        banco.transferir(conta1, conta2, 300, "123");

        System.out.println("\n===== CARTOES =====");

        cartao1.realizarPagamento(100, "123");

        cartao2.realizarPagamento(250, "");

        System.out.println(
            "Limite disponivel: R$ " +
            cartao2.getLimiteDisponivel()
        );

        System.out.println("\n===== INVESTIMENTOS =====");

        conta2.aplicarRendimento();

        conta3.investir(500);

        System.out.println("\n===== ANALISE DE CREDITO =====");

        Emprestimo_Financiamento emprestimo =
            new Emprestimo_Financiamento(
                5000,
                5,
                12,
                cliente1
            );

        emprestimo.analisarCredito();

        banco.registrarEmprestimo(emprestimo);

        emprestimo.exibirDados();

        System.out.println("\n===== RELATORIOS =====");

        banco.exibirClientes();

        banco.exibirContas();

        banco.exibirExtrato();

        banco.getAuditoria().registrarAcessoSuspeito(
            "Usuario desconhecido"
        );

        banco.exibirAuditoria();
        System.out.println("\n==================================");
        System.out.println("   SISTEMA FINALIZADO COM SUCESSO");
        System.out.println("==================================");
    }
}
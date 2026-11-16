
public class Emprestimo_Financiamento {
    private double valorSolicitado;
    private double taxaJuros;
    private int quantidadeParcelas;
    private String status;
    private Cliente cliente;

    public Emprestimo_Financiamento(
        double valorSolicitado,
        double taxaJuros,
        int quantidadeParcelas,
        Cliente cliente) {

        this.valorSolicitado = valorSolicitado;
        this.taxaJuros = taxaJuros;
        this.quantidadeParcelas = quantidadeParcelas;
        this.cliente = cliente;
        this.status = "Em analise";
    }

    public void analisarCredito() {
        if (valorSolicitado <= 0 ||
            quantidadeParcelas <= 0 ||
            taxaJuros < 0) {
            status = "Reprovado";

        } else {

            double valorTotal = valorSolicitado *
                (1 + taxaJuros / 100);

            double valorParcela = valorTotal / quantidadeParcelas;

            double rendaPermitida =
                cliente.getRendaMensal() * 0.30;

            if (valorParcela <= rendaPermitida) {
                status = "Aprovado";
            } else {
                status = "Reprovado";
            }
        }

        System.out.println("Resultado da analise: " + status);
    }

    public void exibirDados() {
        System.out.println("\n===== EMPRESTIMO =====");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Valor solicitado e de: R$ " + valorSolicitado);
        System.out.println("Taxa de juros: " + taxaJuros + "%");
        System.out.println("Parcelas: " + quantidadeParcelas);
        System.out.println("Status: " + status);
    }

    public String getStatus() {
        return status;
    }

    public double getValorSolicitado() {
        return valorSolicitado;
    }
}
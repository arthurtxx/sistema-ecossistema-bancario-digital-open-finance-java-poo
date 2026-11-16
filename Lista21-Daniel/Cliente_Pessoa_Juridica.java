
public class Cliente_Pessoa_Juridica extends Cliente {
    private double faturamentoAnual;
    private String nomeFantasia;
    private String ramoAtividade;

    public Cliente_Pessoa_Juridica(
        int id,
        String nome,
        String documento,
        String endereco,
        String nivelKYC,
        double faturamentoAnual,
        String nomeFantasia,
        String ramoAtividade) {

        super(id, nome, documento, endereco, nivelKYC);
        this.faturamentoAnual = faturamentoAnual;
        this.nomeFantasia = nomeFantasia;
        this.ramoAtividade = ramoAtividade;
    }

    @Override
    public double getRendaMensal() {
        return faturamentoAnual / 12;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Faturamento anual e de: R$ " + faturamentoAnual);
        System.out.println("Nome fantasia: " + nomeFantasia);
        System.out.println("Ramo de atividade: " + ramoAtividade);
    }
}
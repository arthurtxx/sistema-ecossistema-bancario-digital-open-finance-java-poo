
public class Cliente_Pessoa_Fisica extends Cliente {
    private String dataNascimento;
    private double rendaMensal;
    private String estadoCivil;

    public Cliente_Pessoa_Fisica(
        int id,
        String nome,
        String documento,
        String endereco,
        String nivelKYC,
        String dataNascimento,
        double rendaMensal,
        String estadoCivil) {

        super(id, nome, documento, endereco, nivelKYC);
        this.dataNascimento = dataNascimento;
        this.rendaMensal = rendaMensal;
        this.estadoCivil = estadoCivil;
    }

    @Override
    public double getRendaMensal() {
        return rendaMensal;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Renda mensal e de: R$ " + rendaMensal);
        System.out.println("Estado civil: " + estadoCivil);
    }
}
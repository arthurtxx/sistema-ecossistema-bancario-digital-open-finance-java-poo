
public abstract class Cliente {
    private int id;
    private String nome;
    private String documento;
    private String endereco;
    private String nivelKYC;

    public Cliente(
        int id,
        String nome,
        String documento,
        String endereco,
        String nivelKYC) {

        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.nivelKYC = nivelKYC;
    }

    public abstract double getRendaMensal();
    public void exibirDados() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Documento: " + documento);
        System.out.println("Endereco: " + endereco);
        System.out.println("Nivel KYC: " + nivelKYC);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNivelKYC() {
        return nivelKYC;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
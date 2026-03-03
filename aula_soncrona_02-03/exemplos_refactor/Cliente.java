public class Cliente {
    private final String nome;
    private final String cpf;
    private final Endereco endereco;

    public Cliente(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void exibirDados() {
        System.out.println(nome + " - " + cpf);
        System.out.println(endereco.formatado());
    }
}

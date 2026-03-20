public class Endereco {
    private final String rua;
    private final String numero;
    private final String cidade;

    public Endereco(String rua, String numero, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }

    public String formatado() {
        return rua + ", " + numero + " - " + cidade;
    }
}

package mack.bridge;

public class ContaEspecial extends Conta {

    private String titular;
    private float limite;

    public ContaEspecial(String titular, float saldoInicial,
                         float limite, Saque estrategiaDeSaque) {
        super(saldoInicial, estrategiaDeSaque);
        this.titular = titular;
        this.limite = limite;
    }

    @Override
    protected float getLimite() {
        return limite;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== Conta Especial ===");
        System.out.println("Titular : " + titular);
        System.out.println("Saldo   : R$" + saldo);
        System.out.println("Limite  : R$" + limite);
    }


}

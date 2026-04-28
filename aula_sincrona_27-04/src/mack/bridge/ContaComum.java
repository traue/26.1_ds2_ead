package mack.bridge;

public class ContaComum extends Conta {

    private String titular;

    public ContaComum(String titular, float saldoInicial, Saque estrategiaDeSaque) {
        super(saldoInicial, estrategiaDeSaque);
        this.titular = titular;
    }

    @Override
    protected float getLimite() {
        // Conta comum não possui limite de crédito
        return 0f;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== Conta Comum ===");
        System.out.println("Titular : " + titular);
        System.out.println("Saldo   : R$" + saldo);
        System.out.println("Limite  : não possui");
    }


}

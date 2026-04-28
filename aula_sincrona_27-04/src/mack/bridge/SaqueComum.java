package mack.bridge;

public class SaqueComum implements Saque {

    @Override
    public float executarSaque(float saldo, float limite, float valor) {
        // Regra de negócio: não permite saldo negativo
        if (valor > saldo) {
            System.out.println("[SaqueComum] Saque NEGADO. "
                    + "Valor solicitado: R$" + valor
                    + " | Saldo disponível: R$" + saldo);
            return saldo; // saldo permanece inalterado
        }
        float novoSaldo = saldo - valor;
        System.out.println("[SaqueComum] Saque APROVADO. "
                + "Valor: R$" + valor
                + " | Saldo anterior: R$" + saldo
                + " | Novo saldo: R$" + novoSaldo);
        return novoSaldo;
    }


}

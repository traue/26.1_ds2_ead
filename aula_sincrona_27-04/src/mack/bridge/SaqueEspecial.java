package mack.bridge;

public class SaqueEspecial implements Saque {
    @Override
    public float executarSaque(float saldo, float limite, float valor) {
        // Regra de negócio: pode usar até saldo + limite
        float totalDisponivel = saldo + limite;

        if (valor > totalDisponivel) {
            System.out.println("[SaqueEspecial] Saque NEGADO. "
                    + "Valor solicitado: R$" + valor
                    + " | Total disponível (saldo + limite): R$" + totalDisponivel);
            return saldo;
        }
        float novoSaldo = saldo - valor;
        System.out.println("[SaqueEspecial] Saque APROVADO. "
                + "Valor: R$" + valor
                + " | Saldo anterior: R$" + saldo
                + " | Novo saldo: R$" + novoSaldo
                + (novoSaldo < 0 ? " (usando limite de crédito)" : ""));
        return novoSaldo;
    }

}

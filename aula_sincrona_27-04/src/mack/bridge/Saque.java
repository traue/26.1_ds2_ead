package mack.bridge;

public interface Saque {

    /**
     * Executa a operação de saque.
     *
     * @param saldo  saldo atual da conta antes do saque
     * @param limite limite de crédito disponível (0 para contas sem limite)
     * @param valor  valor solicitado para saque
     * @return novo saldo após o saque, ou o saldo original se o saque for negado
     */
    float executarSaque(float saldo, float limite, float valor);

}

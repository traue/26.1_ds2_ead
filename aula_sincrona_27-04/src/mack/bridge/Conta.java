package mack.bridge;

public abstract class Conta {

    protected float saldo;

    // A "ponte": referência para o lado da implementação.
    // Pode ser trocada em tempo de execução sem alterar esta classe.
    protected Saque estrategiaDeSaque;

    public Conta(float saldoInicial, Saque estrategiaDeSaque) {
        this.saldo = saldoInicial;
        this.estrategiaDeSaque = estrategiaDeSaque;
    }

    public float getSaldo() {
        return saldo;
    }

    /**
     * Permite trocar a estratégia de saque em tempo de execução.
     * Este é um dos grandes benefícios do Bridge.
     */
    public void setEstrategiaDeSaque(Saque estrategiaDeSaque) {
        this.estrategiaDeSaque = estrategiaDeSaque;
    }

    /**
     * Delega a execução do saque para a implementação associada.
     * A Conta não precisa saber as regras — ela apenas coordena.
     */
    public void realizarSaque(float valor) {
        // Delegação: a conta passa os dados, a estratégia decide o que fazer
        this.saldo = estrategiaDeSaque.executarSaque(this.saldo, getLimite(), valor);
    }

    /**
     * Cada subclasse define seu próprio limite.
     * ContaComum retorna 0; ContaEspecial retorna o limite configurado.
     */
    protected abstract float getLimite();

    public abstract void exibirInformacoes();


}

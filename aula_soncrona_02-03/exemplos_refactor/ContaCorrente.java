public class ContaCorrente {
    private double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public double consultarSaldo() {
        return saldo;
    }
}

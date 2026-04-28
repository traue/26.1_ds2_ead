package mack.bridge;

public class TesteBridge {

    public static void main(String[] args) {
        // --------------------------------------------------
        // TESTE 1: Conta Comum — saque dentro e fora do saldo
        // --------------------------------------------------
        System.out.println("====================================");
        System.out.println(" TESTE 1 — Conta Comum, saldo insuficiente");
        System.out.println("====================================");

        Conta contaComum = new ContaComum("Ana Lima", 500f, new SaqueComum());
        contaComum.exibirInformacoes();
        System.out.println();

        contaComum.realizarSaque(300f);  // aprovado: saldo passa para 200
        contaComum.realizarSaque(250f);  // negado: saldo restante é 200
        System.out.println();
        contaComum.exibirInformacoes();

        System.out.println();

        // --------------------------------------------------
        // TESTE 2: Conta Especial usando o limite de crédito
        // --------------------------------------------------
        System.out.println("====================================");
        System.out.println(" TESTE 2 — Conta Especial com limite");
        System.out.println("====================================");

        Conta contaEspecial = new ContaEspecial("Bruno Costa", 200f, 1000f, new SaqueEspecial());
        contaEspecial.exibirInformacoes();
        System.out.println();

        contaEspecial.realizarSaque(150f);   // usa saldo: 200 - 150 = 50
        contaEspecial.realizarSaque(800f);   // usa saldo restante + limite: 50 + 1000 = 1050 disponível
        contaEspecial.realizarSaque(500f);   // negado: limite consumido
        System.out.println();
        contaEspecial.exibirInformacoes();

        System.out.println();

        // --------------------------------------------------
        // TESTE 3: Troca de estratégia em tempo de execução
        // Aqui está o poder do Bridge: trocar a implementação
        // sem modificar nenhuma classe existente.
        // --------------------------------------------------
        System.out.println("====================================");
        System.out.println(" TESTE 3 — Troca de estratégia em tempo de execução");
        System.out.println("====================================");

        // Começa com SaqueComum — sem limite
        Conta contaUpgradada = new ContaEspecial("Carla Souza", 300f, 500f, new SaqueComum());
        contaUpgradada.exibirInformacoes();
        System.out.println();

        contaUpgradada.realizarSaque(400f); // negado: SaqueComum não usa limite

        System.out.println("\n[Sistema] Cliente fez upgrade. Trocando estratégia de saque...\n");

        // Troca apenas a estratégia — a conta e seus dados continuam intactos
        contaUpgradada.setEstrategiaDeSaque(new SaqueEspecial());

        contaUpgradada.realizarSaque(400f); // aprovado agora: SaqueEspecial usa o limite
        contaUpgradada.exibirInformacoes();

        System.out.println();

        // --------------------------------------------------
        // TESTE 4: Nova regra de saque SEM alterar nenhuma classe existente
        // Princípio OCP: aberto para extensão, fechado para modificação.
        // --------------------------------------------------
        System.out.println("====================================");
        System.out.println(" TESTE 4 — Nova regra: Saque com taxa");
        System.out.println(" (sem alterar nenhuma classe existente)");
        System.out.println("====================================");

        // Em produção, seria uma nova classe SaqueComTaxa.java
        // Aqui usamos classe anônima para agilizar a demonstração ao vivo
        Saque saqueComTaxa = new Saque() {
            private static final float TAXA = 0.02f; // 2% de taxa por saque

            @Override
            public float executarSaque(float saldo, float limite, float valor) {
                float valorComTaxa = valor * (1 + TAXA);
                if (valorComTaxa > saldo) {
                    System.out.println("[SaqueComTaxa] Saque NEGADO. "
                            + "Valor com taxa (2%): R$" + valorComTaxa
                            + " | Saldo: R$" + saldo);
                    return saldo;
                }
                float novoSaldo = saldo - valorComTaxa;
                System.out.println("[SaqueComTaxa] Saque APROVADO. "
                        + "Valor: R$" + valor
                        + " | Taxa (2%): R$" + (valor * TAXA)
                        + " | Total debitado: R$" + valorComTaxa
                        + " | Novo saldo: R$" + novoSaldo);
                return novoSaldo;
            }
        };

        Conta contaComTaxa = new ContaComum("Daniel Farias", 1000f, saqueComTaxa);
        contaComTaxa.exibirInformacoes();
        System.out.println();

        contaComTaxa.realizarSaque(500f);
        contaComTaxa.realizarSaque(600f); // negado após o débito anterior com taxa
        System.out.println();
        contaComTaxa.exibirInformacoes();

    }

}

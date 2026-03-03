public class App {
    public static void main(String[] args) {
        executarExemploExtractMethod();
        executarExemploExtractClass();
        executarExemploSeparateQueryFromModifier();
    }

    private static void executarExemploExtractMethod() {
        NotaFiscalService notaFiscalService = new NotaFiscalService();

        System.out.println("\n=== EXEMPLO A: Extract Method ===");
        System.out.println("\nAntes:");
        notaFiscalService.imprimirNotaAntes("Anitta", 139.90);

        System.out.println("\nDepois:");
        notaFiscalService.imprimirNotaDepois("Anitta", 139.90);
    }

    private static void executarExemploExtractClass() {
        Cliente cliente = new Cliente(
                "Ludi",
                "111.222.333-44",
                new Endereco("Rua das Flores", "123", "São Paulo")
        );

        System.out.println("\n=== EXEMPLO B: Extract Class ===");
        cliente.exibirDados();
    }

    private static void executarExemploSeparateQueryFromModifier() {
        ContaCorrente conta = new ContaCorrente();

        System.out.println("\n=== EXEMPLO C: Separate Query from Modifier ===");
        conta.depositar(1000.00);
        conta.sacar(250.00);
        System.out.println("Saldo final: R$ " + conta.consultarSaldo());
    }
}

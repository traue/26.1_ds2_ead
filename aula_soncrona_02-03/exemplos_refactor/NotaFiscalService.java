public class NotaFiscalService {
    public void imprimirNotaAntes(String cliente, double total) {
        System.out.println("=== FARMÁCIA XPTO ===");
        System.out.println("CNPJ: 00.000.000/0001-00");
        System.out.println("---------------------");

        System.out.println("Cliente: " + cliente);
        System.out.println("Total: R$ " + total);

        System.out.println("---------------------");
        System.out.println("Volte sempre!");
    }

    public void imprimirNotaDepois(String cliente, double total) {
        imprimirCabecalho();
        imprimirCompra(cliente, total);
        imprimirRodape();
    }

    private void imprimirCabecalho() {
        System.out.println("=== FARMÁCIA XPTO ===");
        System.out.println("CNPJ: 00.000.000/0001-00");
        System.out.println("---------------------");
    }

    private void imprimirCompra(String cliente, double total) {
        System.out.println("Cliente: " + cliente);
        System.out.println("Total: R$ " + total);
    }

    private void imprimirRodape() {
        System.out.println("---------------------");
        System.out.println("Volte sempre!");
    }
}

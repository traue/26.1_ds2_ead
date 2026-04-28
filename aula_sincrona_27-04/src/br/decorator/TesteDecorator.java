package br.decorator;

public class TesteDecorator {

    private static void imprimirPedido(String numeroPedido, Elemento pedido) {
        System.out.println("----------------------------------");
        System.out.println("Pedido #" + numeroPedido);
        System.out.println("Itens   : " + pedido.getDescricao());
        System.out.printf( "Total   : R$%.2f%n", pedido.getPreco());
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        // Tabela de preços do estabelecimento
        final float PRECO_CAFE      = 4.00f;
        final float PRECO_LEITE     = 1.50f;
        final float PRECO_CANELA    = 0.75f;
        final float PRECO_CHANTILLY = 4.55f;

        System.out.println("======================================");
        System.out.println("        CAFETERIA MACKENZIE");
        System.out.println("======================================");
        System.out.println();

        // --------------------------------------------------
        // PEDIDO 1: Café puro
        // Mostra que o componente base funciona sozinho.
        // --------------------------------------------------
        Elemento pedido1 = new Cafe(PRECO_CAFE);
        imprimirPedido("001 — Café puro", pedido1);
        // Esperado: R$4,00

        System.out.println();

        // --------------------------------------------------
        // PEDIDO 2: Café com leite
        // Uma camada de decoração sobre o componente base.
        // --------------------------------------------------
        Elemento pedido2 = new Leite(
                new Cafe(PRECO_CAFE),
                PRECO_LEITE);
        imprimirPedido("002 — Café com leite", pedido2);
        // Esperado: R$5,50

        System.out.println();

        // --------------------------------------------------
        // PEDIDO 3: Café com leite e chantilly
        // Duas camadas de decoração.
        // Leitura de fora para dentro: Chantilly -> Leite -> Café
        // Cálculo: 4,00 + 1,50 + 4,55 = 10,05
        // --------------------------------------------------
        Elemento pedido3 = new Chantilly(
                new Leite(
                        new Cafe(PRECO_CAFE),
                        PRECO_LEITE),
                PRECO_CHANTILLY);
        imprimirPedido("003 — Café com leite e chantilly", pedido3);
        // Esperado: R$10,05

        System.out.println();

        // --------------------------------------------------
        // PEDIDO 4: Café com todos os adicionais
        // --------------------------------------------------
        Elemento pedido4 = new Chantilly(
                new Canela(
                        new Leite(
                                new Cafe(PRECO_CAFE),
                                PRECO_LEITE),
                        PRECO_CANELA),
                PRECO_CHANTILLY);
        imprimirPedido("004 — Café completo", pedido4);
        // Esperado: R$10,80

        System.out.println();

        // --------------------------------------------------
        // PEDIDO 5: Café com leite DUPLO
        // O mesmo decorator pode ser aplicado mais de uma vez!
        // Isso é impossível com herança pura — não existe
        // subclasse "CafeComDoisLeites". Com Decorator, é trivial.
        // --------------------------------------------------
        Elemento pedido5 = new Leite(
                new Leite(
                        new Cafe(PRECO_CAFE),
                        PRECO_LEITE),
                PRECO_LEITE);
        imprimirPedido("005 — Café com leite duplo", pedido5);
        // Esperado: R$7,00

        System.out.println();

        // --------------------------------------------------
        // PEDIDO 6: Composição dinâmica em tempo de execução
        // A decisão de quais adicionais incluir pode ser feita
        // durante a execução — impossível com herança.
        // --------------------------------------------------
        System.out.println("======================================");
        System.out.println(" PEDIDO 6 — Composição dinâmica");
        System.out.println("======================================");

        // Simula preferências do cliente (poderiam vir de um formulário,
        // banco de dados, entrada do usuário etc.)
        boolean clienteQuerLeite     = true;
        boolean clienteQuerCanela    = false;
        boolean clienteQuerChantilly = true;

        // Começa sempre com o componente base
        Elemento pedidoDinamico = new Cafe(PRECO_CAFE);

        // Cada adicional é "empilhado" conforme a preferência
        if (clienteQuerLeite)     pedidoDinamico = new Leite(pedidoDinamico, PRECO_LEITE);
        if (clienteQuerCanela)    pedidoDinamico = new Canela(pedidoDinamico, PRECO_CANELA);
        if (clienteQuerChantilly) pedidoDinamico = new Chantilly(pedidoDinamico, PRECO_CHANTILLY);

        imprimirPedido("006 — Pedido dinâmico", pedidoDinamico);
        // Esperado com leite + chantilly: R$10,05

        System.out.println();

        // --------------------------------------------------
        // RESUMO para fechar a demonstração ao vivo
        // --------------------------------------------------
        System.out.println("======================================");
        System.out.println(" POR QUE NÃO USAR SÓ HERANÇA?");
        System.out.println("======================================");
        System.out.println("Com 3 adicionais: 2^3 =  8 subclasses necessárias");
        System.out.println("Com 4 adicionais: 2^4 = 16 subclasses necessárias");
        System.out.println("Com 5 adicionais: 2^5 = 32 subclasses necessárias");
        System.out.println();
        System.out.println("Com Decorator: qualquer combinação,");
        System.out.println("sem nenhuma classe nova.");
    }

}

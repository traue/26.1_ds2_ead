package br.decorator;

public abstract class Elemento {

    protected float preco;

    public Elemento(float preco) {
        this.preco = preco;
    }

    /**
     * Cada subclasse calcula seu preço de forma diferente.
     * O Café retorna apenas seu próprio preço.
     * Os Adicionais somam seu preço ao do elemento que decoram.
     */
    public abstract float getPreco();

    /**
     * Retorna uma descrição textual do que foi pedido.
     * Útil para imprimir o "recibo" do pedido ao vivo.
     */
    public abstract String getDescricao();

}

package br.decorator;

public abstract class Adicional extends Elemento {

    // Referência para o elemento que está sendo "decorado".
    // Pode ser um Café (base) ou outro Adicional (empilhamento).
    // O tipo é Elemento — isso é o que permite composição livre.
    protected Elemento elemento;

    public Adicional(Elemento elemento, float precoAdicional) {
        super(precoAdicional);
        this.elemento = elemento;
    }

    @Override
    public float getPreco() {
        // Soma o preço deste adicional ao preço do elemento interno.
        // A chamada é recursiva: cada camada adiciona seu próprio preço.
        return elemento.getPreco() + preco;
    }


}

package br.decorator;

public class Cafe extends Elemento {

    public Cafe(float preco) {
        super(preco);
    }

    @Override
    public float getPreco() {
        // O café retorna apenas seu próprio preço, sem adicionais
        return preco;
    }

    @Override
    public String getDescricao() {
        return "Café";
    }


}

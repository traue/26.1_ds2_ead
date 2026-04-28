package br.decorator;

public class Leite extends Adicional {

    public Leite(Elemento elemento, float precoLeite) {
        super(elemento, precoLeite);
    }

    @Override
    public String getDescricao() {
        // Concatena a descrição do elemento anterior com a própria
        return elemento.getDescricao() + " + Leite";
    }


}

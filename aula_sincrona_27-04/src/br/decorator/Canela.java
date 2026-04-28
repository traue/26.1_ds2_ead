package br.decorator;

public class Canela extends Adicional {

    public Canela(Elemento elemento, float precoCanela) {
        super(elemento, precoCanela);
    }

    @Override
    public String getDescricao() {
        return elemento.getDescricao() + " + Canela";
    }


}

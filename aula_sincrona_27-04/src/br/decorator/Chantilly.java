package br.decorator;

public class Chantilly extends Adicional {

    public Chantilly(Elemento elemento, float precoChantilly) {
        super(elemento, precoChantilly);
    }

    @Override
    public String getDescricao() {
        return elemento.getDescricao() + " + Chantilly";
    }

}

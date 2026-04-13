package br.mack.AbstractFactory;

public class RestauanteItaliano extends Restaurante {

    @Override
    public FastFood criaFastFood()   { return new Pizza(); }

    @Override
    public Sobremesa criaSobremesa() { return new Cannoli(); }


}

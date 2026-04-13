package br.mack.AbstractFactory;

public class RestauranteArabe extends Restaurante {

    @Override
    public FastFood criaFastFood()   { return new Kibe(); }

    @Override
    public Sobremesa criaSobremesa() { return new Ataif(); }


}

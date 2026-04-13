package br.mack.FactoryMethod;

public class FabricaDeSucoLaranja extends FabricaDeSuco {
    @Override
    public Suco fabricaSuco() {
        return new SucoLaranja();
    }

}

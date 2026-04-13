package br.mack.FactoryMethod;

public class FabricaDeSucoMaca extends FabricaDeSuco {

    @Override
    public Suco fabricaSuco() {
        return new SucoMaca();
    }

}

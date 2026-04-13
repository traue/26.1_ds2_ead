package br.mack.FactoryMethod;

public class TesteFactory {

    public static void main(String[] args) {
        FabricaDeSuco fabrica = new FabricaDeSucoMaca();
        Suco s = fabrica.fabricaSuco();
        System.out.println("Sabor: " + s.getSabor()); // Sabor: Maca

        FabricaDeSuco f2 = new FabricaDeSucoLaranja();
        Suco s2 = f2.fabricaSuco();
        System.out.println("Sabor: " + s2.getSabor());


    }
}

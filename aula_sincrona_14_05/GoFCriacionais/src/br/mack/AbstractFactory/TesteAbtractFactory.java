package br.mack.AbstractFactory;

public class TesteAbtractFactory {

    public static void main(String[] args) {
        Restaurante r = new RestauranteArabe(); // troque por RestauranteItaliano à vontade

        FastFood ff = r.criaFastFood();
        Sobremesa sb = r.criaSobremesa();

        System.out.println(ff.getNome() + " + " + sb.getNome()); // "Kibe + Ataif"

    }

}

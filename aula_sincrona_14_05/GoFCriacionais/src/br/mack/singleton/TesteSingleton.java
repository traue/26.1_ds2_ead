package br.mack.singleton;

public class TesteSingleton {

    public static void main(String[] args) {

        System.out.println("-------------P1-------------");
        Presidente p1 = Presidente.getInstance();

        System.out.println(p1.getNome());
        System.out.println(p1.getSalario());

        System.out.println("-------------P2-------------");
        Presidente p2 = Presidente.getInstance();

        System.out.println(p2.getNome());
        System.out.println(p2.getSalario());

        System.out.println("--------P2 ALTERADO--------");
        p2.set("Bob", 10000);

        System.out.println(p1.getNome());
        System.out.println(p1.getSalario());


        System.out.println("-------USANDO OUTRA CLASSE------");
        TesteSingleton2 teste2 = new TesteSingleton2();
        teste2.funcaoQualquer();

    }

}

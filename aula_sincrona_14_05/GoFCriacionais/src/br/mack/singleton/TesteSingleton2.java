package br.mack.singleton;

public class TesteSingleton2 {

    public void funcaoQualquer() {

        Presidente p3 = Presidente.getInstance();

        System.out.println(p3.getNome());
        System.out.println(p3.getSalario());

    }
}

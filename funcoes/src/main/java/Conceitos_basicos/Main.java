package Conceitos_basicos;

public class Main {
    public static void main(String[] args) {
        sayHello("jesse");

        Conversao conversao = new Conversao();

        conversao.conversaoPorMetodos();

        UserInfos userInfos = new UserInfos();
        userInfos.getUserInfos();
    }


    private static void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
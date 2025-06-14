package Conceitos_basicos;

import java.util.Scanner;

public class UserInfos {
    Scanner scanner = new Scanner(System.in);

    public void getUserInfos() {
        System.out.print("Digite seu nome: ");
        String name = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int age = scanner.nextInt();


        System.out.println("Nome: " + name);
        System.out.println("Idade: " + age);
    }
}

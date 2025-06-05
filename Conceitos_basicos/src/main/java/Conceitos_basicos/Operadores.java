package Conceitos_basicos;

public class Operadores {

    public static  void operadores(){
        int num = 10;

        System.out.println(num + 15); // Adição
        System.out.println(num - 5);  // Subtração
        System.out.println(num * 2);  // Multiplicação
        System.out.println(num / 2);  // Divisão
        System.out.println(num % 3);  // Módulo (resto da divisão)
    }

    public static void incrementoDecremento() {
        int num = 10;

        System.out.println(num++); // Pós-incremento (imprime 10, depois incrementa)
        System.out.println(++num); // Pré-incremento (incrementa e depois imprime)

        System.out.println(num--); // Pós-decremento (imprime 12, depois decrementa)
        System.out.println(--num); // Pré-decremento (decrementa e depois imprime)
    }
}

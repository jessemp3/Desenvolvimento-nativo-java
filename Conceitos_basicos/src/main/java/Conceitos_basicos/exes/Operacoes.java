package Conceitos_basicos.exes;

/*Requisitos: Escreva um programa que seja capaz de realizar as operações aritméticas básicas
 * 1. Soma de dois números
 * 2. O valor da divisão de dois números
 * 3. O valor ro resto da divisaão de dois números
 * 4. O valor de incrementar e decrementar uma variável(pré e pós incremento, pré e pós decremento)
 */

public class Operacoes {
    static Integer num1 = 10;
    static Integer num2 = 5;

    public static void Contas(){
        soma(num1, num2);
        divisaao(num1, num2);
        restoDivisao(num1, num2);
        incremento(num1);
        decremento(num1);
    }

    public static void soma(int a, int b){
        int resultado = a + b;
        System.out.println("Soma: " + resultado);
    }

    public static void divisaao(int a, int b ){
        int resultado = a / b;
        System.out.println("Divisão: " + resultado);
    }

    public static void restoDivisao(int a, int b){
        int resultado = a % b;
        System.out.println("Resto da Divisão: " + resultado);
    }

    public static void incremento(int a){
        int resultado = ++a; // Pré-incremento
        System.out.println("Pré-incremento: " + resultado);
        // Pós-incremento ,
        System.out.println("Pós-incremento: " + resultado++);
    }

    public static void decremento(int a){
        int resultado = --a; // Pré-decremento
        System.out.println("Pré-decremento: " + resultado);

        System.out.println("Pós-decremento: " + resultado--);
    }

}

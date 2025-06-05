package Conceitos_basicos;

public class FormatacaoStrings {
    public static void Formatacao() {
        String name = "jesse";

        System.out.println("Olá, " + name + "!"); // Concatenação simples

//         %s = String
//         %d = inteiro
//         %f = float
//         %b = boolean
//         %c = char
//         %t = data/hora
//         %n = nova linha
//         %x = hexadecimal
//         %o = octal
//         %e = notação científica


        String str = String.format("Olá, %s %s!", "Mr", name); // Formatação com String.format

        System.out.println(str); // Imprime a string formatada
    }
}

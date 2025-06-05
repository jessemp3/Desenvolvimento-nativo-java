package Conceitos_basicos;

/***
 * Classe Strings demonstra o uso de métodos comuns da classe String em Java.
 * Inclui operações como conversão de maiúsculas/minúsculas, busca de substrings,
 * substituição de texto, e manipulação de espaços em branco.
 */

public class Strings {
    public static void String(){
        String str = " Hello World";

        System.out.println(str); // Imprime a string original
        System.out.println(str.length()); // Imprime o tamanho da string
        System.out.println(str.toUpperCase()); // Converte a string para maiúsculas
        System.out.println(str.toLowerCase()); // Converte a string para minúsculas
        System.out.println(str.charAt(0)); // Imprime o primeiro caractere da string
        System.out.println(str.indexOf("World")); // Encontra o índice da substring "World"
        System.out.println(str.substring(0, 5)); // Extrai a substring do índice 0 ao 5
        System.out.println(str.replace("World", "Java")); // Substitui "World" por "Java"
        System.out.println(str.contains("Hello")); // Verifica se a string contém "Hello"
        System.out.println(str.startsWith("Hello")); // Verifica se a string começa com "Hello"
        System.out.println(str.endsWith("World")); // Verifica se a string termina com "World"
        System.out.println(str.split(" ")); // Divide a string em um array de substrings usando espaço como delimitador
        System.out.println(str.trim()); // Remove espaços em branco no início e no final da string
        System.out.println(str.isEmpty()); // Verifica se a string está vazia
        System.out.println(str.equals(" Hello World")); // Compara se a string é igual a "Hello World"
    }
}

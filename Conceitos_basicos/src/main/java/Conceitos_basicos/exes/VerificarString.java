package Conceitos_basicos.exes;



public class VerificarString {
    static String palavra = "Android é legal";

    public void Verificar(){
        maiuscula();
        minuscula();
        tamanho();
        possui();
    }

    public static void maiuscula(){
        String palavraMaiuscula = palavra.toUpperCase();
        System.out.println("Palavra em maiúsculas: " + palavraMaiuscula);
    }

    public static void minuscula(){
        String palavraMinuscula = palavra.toLowerCase();
        System.out.println("Palavra em minúsculas: " + palavraMinuscula);
    }

    public static void tamanho(){
        int tamanho = palavra.length();
        System.out.println("Tamanho da palavra: " + tamanho);
    }

    public static void possui(){
        String possuiPalavra = "Android";
        System.out.println(palavra.contains(possuiPalavra));
    }
}

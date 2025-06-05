package Conceitos_basicos.exes;

/**
 * Classe Retangulo
 *
 * Esta classe representa um retângulo e calcula sua área.
 * Para calcular a área do retângulo, basta calcular o produto entre a sua base e a sua altura, ou seja, a área é dada pela fórmula A=b⋅h. Além da área, outra grandeza importante é o perímetro.
 */

public class Retangulo {
    Double b = 20.0;
    Double h = 10.0;

    public void CalculoRetangulo(){
        Double a = b * h;
        System.out.println("A área do retângulo é: " + a);
    }
}

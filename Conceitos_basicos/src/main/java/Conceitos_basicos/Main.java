package Conceitos_basicos;

import Conceitos_basicos.exes.Armazenar;
import Conceitos_basicos.exes.Operacoes;
import Conceitos_basicos.exes.Retangulo;
import Conceitos_basicos.exes.VerificarString;

//
public class Main {
    public static void main(String[] args) {
        String comeco = "Hello World";
        int a = 10;

//        System.out.println(comeco + " " + Types.by.MAX_VALUE);
//        Operadores.operadores();
//        Operadores.incrementoDecremento();

//        Strings.String();
//        FormatacaoStrings.Formatacao();

        System.out.println("Exe1");
        Retangulo retangulo = new Retangulo();
        retangulo.CalculoRetangulo();

        System.out.println("--------------------------");

        System.out.println("Exe2");
        Armazenar armazenar = new Armazenar();
        armazenar.armazenarMethod();

        System.out.println("--------------------------");

        System.out.println("Exe3");
        Operacoes operacoes = new Operacoes();
        operacoes.Contas();

        System.out.println("--------------------------");

        System.out.println("Exe4");
        VerificarString verificarString = new VerificarString();
        verificarString.Verificar();
    }
}
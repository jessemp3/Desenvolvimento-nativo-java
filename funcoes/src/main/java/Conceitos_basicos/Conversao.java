package Conceitos_basicos;

public class Conversao {
    // byte , short , int , long , float e double

    // Conversão implicita
    byte a = 10;
    short b = a; // byte é menor que short, então é possível fazer a conversão implícita

    // Conversão explícita
    double c = 10.5;
    float d = (float) c; // double é maior que float, então é necessário fazer a conversão explícita
    long e = (long) d; // float é maior que long, então é necessário fazer a conversão explícita
    int f = (int) e; // long é maior que int, então é necessário fazer a conversão explícita
    short g = (short) f; // int é maior que short, então é necessário fazer a conversão explícita
    byte h = (byte) g; // short é maior que byte, então é necessário fazer a conversão explícita

//    auto-boxing
    int num1 = 10;
    Integer num2 = num1;

    // auto-unboxing
    Integer num3 = 20;
    int num4 = num3;


    //conversão por metodos
    public void conversaoPorMetodos() {
        System.out.println(Byte.parseByte("10")); // converte String para byte
        System.out.println(Boolean.parseBoolean("true")); // converte String para boolean
    }
}

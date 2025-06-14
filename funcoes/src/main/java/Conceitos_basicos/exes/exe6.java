package Conceitos_basicos.exes;

public class exe6 {
    private String wordConverted;

    public void readString(String word){
        wordConverted = word.replace("a" , "x");

        print(word);
    }

    public void print(String word){
        System.out.println("A palavra original é: " + word);
        String wordConvertedUp = wordConverted.toUpperCase();
        System.out.println("A palavra convertida é: " + wordConvertedUp);
    }



}

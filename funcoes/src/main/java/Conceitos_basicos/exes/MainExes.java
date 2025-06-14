package Conceitos_basicos.exes;

public class MainExes {
    public static void main(String[] args) {
        // exe1
        Exe1 exe1 = new Exe1();
        System.out.println("Exe1");
        exe1.requestYear();
        exe1.convertYearToDays();
        exe1.convertYearToMonths();
        exe1.convertYearToWeeks();
        exe1.convertYearsToHours();
        exe1.convertYearsToMinutes();
        exe1.convertYearsToSeconds();


        //exe2
        Exe2 exe2 = new Exe2();
        System.out.println("Exe2");
        exe2.returnStringLength("sickk");

        //exe3
        Exe3 exe3 = new Exe3();
        System.out.println("Exe3");
        exe3.calculoDeCubo(20, 30, 40);

        //exe4
        Exe4 exe4 = new Exe4();
        System.out.println("Exe4");
        exe4.converterMilhasToKilometros(2);

        //exe5
        Exe5 exe5 = new Exe5();
        System.out.println("Exe5");
        exe5.convertCelsiusToFahrenheit(30);

        //exe6
        exe6 exe6 = new exe6();
        System.out.println("Exe6");
        exe6.readString("banana");

    }

}

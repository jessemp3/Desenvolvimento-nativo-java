package Conceitos_basicos.exes;

import java.util.Scanner;

public class Exe1 {
    Scanner scanner = new Scanner(System.in);
    int years;

    public void requestYear(){
        System.out.println("Digite o ano que deseja transformar: ");
        years = scanner.nextInt();
    }

    public void convertYearToDays(){
        int days = years * 365;
        System.out.println("O ano " + years + " em dias é: " + days);
    }

    public void convertYearToMonths(){
        int months = years * 12;
        System.out.println("O ano " + years + " em meses é: " + months);
    }

    public void convertYearToWeeks(){
        int weeks = years * 52;
        System.out.println("O ano " + years + " em semanas é: " + weeks);
    }

    public void convertYearsToHours(){
        int hours = years * 365 * 24;
        System.out.println("O ano " + years + " em horas é: " + hours);
    }

    public void convertYearsToMinutes(){
        int minutes = years * 365 * 24 * 60;
        System.out.println("O ano " + years + " em minutos é: " + minutes);
    }

    public void convertYearsToSeconds(){
        int seconds = years * 365 * 24 * 60 * 60;
        System.out.println("O ano " + years + " em segundos é: " + seconds);
    }


}

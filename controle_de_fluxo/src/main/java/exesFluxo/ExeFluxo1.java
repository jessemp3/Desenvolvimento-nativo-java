package exesFluxo;

public class ExeFluxo1 {
    public void count1To50(){
        for (int i = 1; i <= 50; i++) {
            System.out.println(i);
        }
    }

    public void count50To1(){
        for (int i = 50; i >= 1; i--) {
            System.out.println(i);
        }
    }

    public void count1To50Even(){
        for (int i = 1; i <= 50; i++) {
            if (i % 5 == 0) {
                System.out.println(i);
            }
        }
    }

    public void count1To50Odd(){
        int count = 0;
        for (int i = 1; i <= 500; i++) {
            count += i;
        }
        System.out.println("A soma dos números de 1 a 500 é: " + count);
    }

    public void escada(){
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

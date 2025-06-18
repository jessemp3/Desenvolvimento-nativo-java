package exes;

public class MainExes {
    public static void main(String[] args) {
        Exe1 exe1 = new Exe1();
        exe1.CalcularBonus("engenheiro de software");

        System.out.println("---------------------");

        Exe2 exe2 = new Exe2();
        exe2.CalcularBonus("gerente", 3);
    }
}

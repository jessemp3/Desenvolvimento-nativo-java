package exes;

public class Exe1 {
   public void CalcularBonus(String cargos){
        String gerente = "gerente";
        String coordenador = "coordenador";
        String EngenheiroDev = "engenheiro de software";
        String estagiario = "estagiario";

       float bonus = 0F;
        
        if (cargos.equals(gerente)) {
            bonus = 2000F;
            System.out.println("O bonus do gerente é: " + bonus);
        } else if (cargos.equals(coordenador)) {
            bonus = 1500F;
            System.out.println("O bonus do coordenador é: " + bonus);
        } else if (cargos.equals(EngenheiroDev)) {
            bonus = 1000F;
            System.out.println("O bonus do engenheiro de software é: " + bonus);
        } else if (cargos.equals(estagiario)) {
            bonus = 500F;
            System.out.println("O bonus do estagiario é: " + bonus);
        } else {
            System.out.println("Cargo não reconhecido.");
        }
   }
}

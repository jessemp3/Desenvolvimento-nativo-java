package exes;

public class Exe2{

    public void CalcularBonus(String cargos , int experiencia) {
        String gerente = "gerente";
        String coordenador = "coordenador";
        String EngenheiroDev = "engenheiro de software";
        String estagiario = "estagiario";

        float bonus = 0F;

        if (cargos.equals(gerente) && experiencia <= 2) {
            bonus = 2000F;
            System.out.println("o bonus do gerente é: " + bonus);
        } else if (cargos.equals(gerente) && experiencia > 2) {
            bonus = 3000F;
            System.out.println("o bonus do gerente é: " + bonus);
        }

        if (cargos.equals(coordenador) && experiencia <= 1) {
            bonus = 1500F;
            System.out.println("o bonus do coordenador é: " + bonus);
        } else if (cargos.equals(coordenador) && experiencia > 1) {
            bonus = 1800F;
            System.out.println("o bonus do coordenador é: " + bonus);
        }

        if (cargos.equals(EngenheiroDev)) {
            bonus = 1000F;
            System.out.println("o bonus do engenheiro de software é: " + bonus);
        }else if( cargos.equals(estagiario)) {
            bonus = 500F;
            System.out.println("o bonus do estagiario é: " + bonus);
        }
    }
}

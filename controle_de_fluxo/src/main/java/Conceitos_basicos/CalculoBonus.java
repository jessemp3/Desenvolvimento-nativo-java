package Conceitos_basicos;

public class CalculoBonus {

    public float calcularBonus(int experiencia, String cargo) {
        //early return (retorno antecipado se o valor desejado for encontrado)
        if(cargo.equals("diretor")){
            return 10000;
        }

        if (experiencia == 0) {
            return 500;
        }else if(experiencia > 1 && experiencia <= 3) {
            return 2000;
        }else{
            return 5000;
        }
    }
}

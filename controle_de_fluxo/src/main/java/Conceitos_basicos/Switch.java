package Conceitos_basicos;

public class Switch {
    private float calculoMensalidade(String curso) {
        float valor;

        switch (curso) {
            case "Java" ->
                valor = 500;
            case "Python" ->
                valor = 600;
            case "JavaScript" ->
                valor =700;
            default ->
                valor = 0;
        }
        return valor;
    }
}

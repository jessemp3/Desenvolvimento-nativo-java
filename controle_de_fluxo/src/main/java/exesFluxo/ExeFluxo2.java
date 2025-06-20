package exesFluxo;

public class ExeFluxo2 {
    public void caixaDeAgua(){
        int capacidade = 2000; // Capacidade total da caixa d'água em litros
        int nivelAtual = 0; // Nível atual da água na caixa d'água

        while (nivelAtual < capacidade) {
            System.out.println("Nível atual da água: " + nivelAtual + " litros");
            System.out.println("Adicionando água...");
            nivelAtual += 100; // Adiciona 100 litros de água a cada iteração
            if (nivelAtual > capacidade) {
                System.out.println("A caixa d'água transbordou!");
                break;
            }
        }
        System.out.println("Caixa d'água cheia!");
    }
}

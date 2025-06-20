package others_exes;

import java.util.Scanner;

public class Exe4 {
     Scanner sc = new Scanner(System.in);
//
//     String[] convite = {"comum", "premium", "luxo"};
//     String[] codigoConvite = {"XT", "XL"};
//
//
     public void portariaDeEvento(int idadade){

         System.out.println("Digite o seu convite (comum, premium, luxo): ");
         String conviteEscolhido = sc.nextLine().toLowerCase();

         System.out.println("Digite o código do convite (XT, XL): ");
         String codigoConviteEscolhido = sc.nextLine().toUpperCase();


         if(idadade > 18){
             if(conviteEscolhido.equals("comum") && codigoConviteEscolhido.equals("XT")){
                    System.out.println("Entrada permitida na área comum");
             }else if(conviteEscolhido.equals("premium") && codigoConviteEscolhido.equals("XL")){
                 System.out.println("Entrada permitida na área premium");
             }else if(conviteEscolhido.equals("luxo") && (codigoConviteEscolhido.equals("XT"))) {
                 System.out.println("Entrada permitida na área de luxo");
             }
         }else {
             System.out.println("Entrada não permitida");
         }
     }
}

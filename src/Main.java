import exceptions.NaoExisteRegistroException;
import tela.FabricaTela;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws NaoExisteRegistroException {

        Scanner scan = new Scanner(System.in);

        int sair = -1;

        while(sair != 4){
            out.println("==============================");
            out.println("Bem vindo ao estacione seguro:");
            out.println("==============================");

            out.println("Digite: 1 - Entrada Veículo | 2 - Saída Veículo | 3 - Snapshot | 4 - Sair");

            int opcao = scan.nextInt();
            if(opcao == 4){
                out.println("Até logo.");
                sair = 4;
                break;
            }
            else{ FabricaTela.getTela(scan, opcao); }
        }

        out.println("Fim do Programa");
    }

}
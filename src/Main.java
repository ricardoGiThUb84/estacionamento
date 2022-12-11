import BancoDeDados.Repositorio;
import exceptions.NaoExisteRegistroException;
import tela.TelaSistema;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws NaoExisteRegistroException {

        Scanner scan = new Scanner(System.in);

        int sair = -1;

        while(sair != 3){
            out.println("==============================");
            out.println("Bem vindo ao estacione seguro:");
            out.println("==============================");

            out.println("Digite: 1 - Entrada Veículo | 2 - Saída Veículo | 3 - Sair");

            switch(scan.nextInt()){
                case 1:
                    TelaSistema.entrada(scan);
                    break;
                case 2:
                    out.println("implementar");
                    break;
                case 3:
                    sair = 3;
                    break;
                default:
                    out.println("Entrada inválida");
            }

            out.println("Fim do Programa");
        }



        Repositorio.getInstance().listaRegistrosComDataHoraSaidaParcial("12-12-2012-16-25");

    }

}
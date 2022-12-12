import BancoDeDados.Repositorio;
import exceptions.NaoExisteRegistroException;
import tela.TelaSistema;
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

            switch(scan.nextInt()){
                case 1:
                    TelaSistema.entrada(scan);
                    break;
                case 2:
                    TelaSistema.saida(scan);
                    break;
                case 3:
                    Repositorio.getInstance().listaRegistrosComDataHoraSaidaParcial("13-12-2022-18-00");
                    break;
                case 4:
                    sair = 4;
                    break;
                default:
                    out.println("Entrada inválida");
            }
        }

        out.println("Fim do Programa");
    }

}
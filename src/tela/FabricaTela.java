package tela;

import exceptions.NaoExisteRegistroException;

import java.util.Scanner;

import static java.lang.System.out;

public class FabricaTela {
    public static void getTela(Scanner scan, String opcao) throws NaoExisteRegistroException {

        switch(opcao){
            case "1":
                TelaSistema.cadastrarEntrada(scan);
                break;
            case "2":
                TelaSistema.cadastrarSaida(scan);
                break;
            case "3":
                TelaRelatorio.gerarRelatorio(scan);
                break;
            default:
                out.println("Entrada inválida");
        }

    }
}

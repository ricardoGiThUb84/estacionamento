import exceptions.NaoExisteRegistroException;
import tela.FabricaTela;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws NaoExisteRegistroException, FileNotFoundException {

        //Scanner scan = new Scanner(System.in);   //Teste manual
        Scanner scan = new Scanner(getPathDoArquivo().toFile()); //Teste automatico

        int sair = -1;

        while(sair != 4){
            out.println("==============================");
            out.println("Bem vindo ao estacione seguro:");
            out.println("==============================");

            out.println("Digite: 1 - Entrada Veículo | 2 - Saída Veículo | 3 - Snapshot | 4 - Sair");

            String opcao = scan.next();
            if(opcao.equals("4")){
                out.println("Até logo.");
                sair = 4;
                break;
            }
            else{ FabricaTela.getTela(scan, opcao); }
        }

        out.println("Fim do Programa");
    }

    private static Path getPathDoArquivo(){
        return Paths.get("src", "resources", "teste1.txt").toAbsolutePath();
    }

}
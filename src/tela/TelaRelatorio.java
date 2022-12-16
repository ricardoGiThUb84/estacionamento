package tela;

import BancoDeDados.Repositorio;
import java.util.Scanner;
import static java.lang.System.out;

public class TelaRelatorio {

    private static final Repositorio repositorio = Repositorio.getInstance();

    public static void gerarRelatorio(Scanner scan){
        out.println("Informe a data do relatório no formato: dd-mm-aaaa-hh-mm");
        repositorio.listaRegistrosComDataHoraSaidaParcial(scan.next());
    }
}

package tela;

import BancoDeDados.Repositorio;
import java.util.Scanner;
import static java.lang.System.out;

public class TelaRelatorio extends Tela{

    private static final Repositorio repositorio = Repositorio.getInstance();

    public static void gerarRelatorio(){
        repositorio.listarVeiculosEstacionados();
    }
}

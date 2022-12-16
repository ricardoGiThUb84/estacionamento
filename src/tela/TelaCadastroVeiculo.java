package tela;

import BancoDeDados.Repositorio;
import entidade.Veiculo;
import java.util.Scanner;
import static java.lang.System.out;

public class TelaCadastroVeiculo {

    private static final Repositorio repositorio = Repositorio.getInstance();

    public static Veiculo cadastrarVeiculo(Scanner scan, String placa){

        out.println("Digite o modelo do veículo:");
        Veiculo veiculo = new Veiculo(scan.next(), placa);
        repositorio.adicionarVeiculo(veiculo);
        return veiculo;
    }

}

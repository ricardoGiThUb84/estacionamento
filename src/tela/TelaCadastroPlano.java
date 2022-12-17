package tela;

import BancoDeDados.Repositorio;
import entidade.TipoPlano;
import entidade.Veiculo;

import java.util.Scanner;

import static java.lang.System.out;

public class TelaCadastroPlano {

    private static final Repositorio repositorio = Repositorio.getInstance();

    public static void cadastrarPlano (Scanner scan){

        out.println("Digite a placa do veículo:");
        String placa = scan.next();

        if(repositorio.retornarDadosVeiculo(placa).isPresent()){
            Veiculo veiculo = repositorio.retornarDadosVeiculo(placa).get();

            System.out.println("Informe o tipo do plano: ");
            for (TipoPlano tipoPlano: TipoPlano.values()) {
                System.out.printf("(%d) - %s - Valor: R$ %.2f\n", tipoPlano.getOpcao(), tipoPlano.getLabel(), tipoPlano.getPreco());
            }
            TipoPlano tipoPlano = TipoPlano.fromOpcao(scan.nextInt());

            repositorio.atualizarVeiculo(veiculo, tipoPlano, tipoPlano.getHoras());
        }
    }
}

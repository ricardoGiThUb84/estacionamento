package tela;

import BancoDeDados.Repositorio;
import entidade.Cliente;
import entidade.Registro;
import entidade.Veiculo;
import exceptions.NaoExisteRegistroException;
import tela.TelaCadastro;

import java.util.Scanner;

import static java.lang.System.out;

public class TelaSistema {

    private static final Repositorio repositorio = Repositorio.getInstance();
    private TelaSistema() {
    }
    public static void entrada(Scanner scan) throws NaoExisteRegistroException {

            out.println("Digite a placa do veículo:");

            String placa = scan.next();

        if(repositorio.verificaSeHaRegistro(placa)){

            out.println("Digite a data e hora entrada no formato: dd-mm-aaaa-hh-mm");
          Registro reg =  repositorio.buscaRegistroPorId(placa);
          reg.setHoraEntrada(scan.next());
          reg.setHoraSaida(null);
          reg.setDataHoraParcial(null);

        }else{
            Veiculo veiculo;
            Cliente cliente;

            out.println("Deseja cadastrar veículo com o cliente? | Sim: (S) ou Não: (N)");

            switch (scan.next().toUpperCase()){
                case "S" :
                   veiculo = TelaCadastro.cadastraVeiculo(scan);
                   cliente = TelaCadastro.cadastraCliente(scan);
                   veiculo.setCondutor(cliente);

                    out.println("Digite a data e hora entrada no formato: dd-mm-aaaa-hh-mm");
                    repositorio.adiciona(TelaCadastro.cadasTrarRegistro(veiculo, scan.next()));
                    break;

                case "N":
                   veiculo = TelaCadastro.cadastraVeiculo(scan);
                    out.println("Digite a data e hora entrada no formato: dd-mm-aaaa-hh-mm");
                   repositorio.adiciona(TelaCadastro.cadasTrarRegistro(veiculo , scan.next()));
                   break;

                default:
                    out.println("Opção inválida!");
            }
        }



    }
}

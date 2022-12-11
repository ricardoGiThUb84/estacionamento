package tela;

import BancoDeDados.Repositorio;
import entidade.Cliente;
import entidade.Registro;
import entidade.TipoRegistro;
import entidade.Veiculo;
import exceptions.NaoExisteRegistroException;

import java.util.Scanner;

import static java.lang.System.out;

public class TelaSistema {

    private static final Repositorio repositorio = Repositorio.getInstance();
    private TelaSistema() {
    }
    public static void entrada(Scanner scan) {

        out.println("Digite a placa do veículo:");
        String placa = scan.next();

        if(repositorio.retornarDadosVeiculo(placa).isPresent()){
            repositorio.adicionarRegistro(new Registro(repositorio.retornarDadosVeiculo(placa).get(), TipoRegistro.ENTRADA));
        }
        else{
            Veiculo veiculo;
            Cliente cliente;
            out.println("Deseja cadastrar veículo com o cliente? | Sim: (S) ou Não: (N)");
            switch (scan.next().toUpperCase()){
                case "S" :
                    veiculo = TelaCadastro.cadastrarVeiculo(scan, placa);
                    cliente = TelaCadastro.cadastraCliente(scan);
                    veiculo.setCondutor(cliente);
                    repositorio.adicionarRegistro(TelaCadastro.cadastrarRegistro(veiculo, TipoRegistro.ENTRADA));
                    break;

                case "N":
                    veiculo = TelaCadastro.cadastrarVeiculo(scan, placa);
                    repositorio.adicionarRegistro(TelaCadastro.cadastrarRegistro(veiculo, TipoRegistro.ENTRADA));
                    break;

                default:
                    out.println("Opção inválida!");
            }
        }
    }

    public static void saida(Scanner scan) throws NaoExisteRegistroException {

        out.println("Digite a placa do veículo:");
        String placa = scan.next();

        if (repositorio.buscaRegistroEntrada(placa).isPresent()) {
            out.println("Digite a data e hora de saída no formato: dd-mm-aaaa-hh-mm");
            repositorio.adicionarRegistro(new Registro(repositorio.retornarDadosVeiculo(placa).get(), TipoRegistro.SAIDA, scan.next()));
            repositorio.retornarDados(placa);
        } else {
            throw new NaoExisteRegistroException("Não há veículo com a placa informada.");
        }
    }
}

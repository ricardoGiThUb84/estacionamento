package tela;

import BancoDeDados.Repositorio;
import Utilitarios.ManipulaDatas;
import entidade.Cliente;
import entidade.RegistroEntrada;
import entidade.RegistroSaida;
import entidade.Veiculo;

import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.System.out;

public class TelaSistema extends Tela{
    private static final Repositorio repositorio = Repositorio.getInstance();

    public static void cadastrarEntrada(Scanner scan) {

        out.println("Digite a placa do veículo:");
        String placa = scan.next();

        if(repositorio.retornarDadosVeiculo(placa).isPresent()){
            //TODO verificar se tem cliente cadastrado (se não, perguntar se deseja cadastrar)

            repositorio.adicionarRegistro(new RegistroEntrada(repositorio.retornarDadosVeiculo(placa).get()));
        }
        else{
            Veiculo veiculo;
            Cliente cliente;
            out.println("Deseja cadastrar veículo com o cliente? | Sim: (S) ou Não: (N)");
            switch (scan.next().toUpperCase()){
                case "S" :
                    veiculo = TelaCadastroVeiculo.cadastrarVeiculo(scan, placa);
                    cliente = TelaCadastroCliente.cadastrarCliente(scan);
                    veiculo.setCondutor(cliente);
                    repositorio.adicionarRegistro(new RegistroEntrada(veiculo));
                    break;

                case "N":
                    veiculo = TelaCadastroVeiculo.cadastrarVeiculo(scan, placa);
                    repositorio.adicionarRegistro(new RegistroEntrada(veiculo));
                    break;

                default:
                    out.println("Opção inválida!");
            }
        }
    }

    public static void cadastrarSaida(Scanner scan) {

        out.println("Digite a placa do veículo:");
        String placa = scan.next();

        if (repositorio.buscarUltimoRegistroEntrada(placa).isPresent()) {
            out.println("Digite a data e hora de saída no formato: dd-mm-aaaa-hh-mm");
            LocalDateTime dataRegistro = ManipulaDatas.formatarStringDataEntradaUsuario(scan.next());
            repositorio.adicionarRegistro(new RegistroSaida(repositorio.retornarDadosVeiculo(placa).get(), dataRegistro));

        } else {
            out.println("Não há veículo com a placa informada.");
        }
    }

}

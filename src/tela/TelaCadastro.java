package tela;

import BancoDeDados.Repositorio;
import entidade.Cliente;
import entidade.Registro;
import entidade.TipoRegistro;
import entidade.Veiculo;

import java.util.Scanner;

import static java.lang.System.out;

public class TelaCadastro {

    private static final Repositorio repositorio = Repositorio.getInstance();
    private TelaCadastro(){};

    public static Veiculo cadastrarVeiculo(Scanner scan, String placa){

        out.println("Digite o modelo do veículo:");
        Veiculo veiculo = new Veiculo(scan.next(), placa);
        repositorio.adicionarVeiculo(veiculo);
        return veiculo;
    }

    public static Cliente cadastraCliente(Scanner scan){
        out.println("Cadastre o cliente");
        out.println("------------------");

        out.println("Digite o nome:");
        String nome = scan.next();

        out.println("Digite a cnh:");
        String cnh = scan.next();

        Cliente cliente = new Cliente(nome, cnh);
        repositorio.adicionarCliente(cliente);
        return cliente;
    }

    public static Registro cadastrarRegistro(Veiculo veiculo, TipoRegistro tipoRegistro){
        return new Registro(veiculo, tipoRegistro);
    }

}

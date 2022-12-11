package tela;

import entidade.Cliente;
import entidade.Registro;
import entidade.Veiculo;

import java.util.Scanner;

import static java.lang.System.out;

public class TelaCadastro {

    private TelaCadastro(){};
    public static Veiculo cadastraVeiculo(Scanner scan){

        String modelo;
        String placa;

        out.println("Cadastre o veículo");
        out.println("------------------");

        out.println("Digite o modelo:");

        modelo = scan.next();

        out.println("Digite a placa:");

        placa = scan.next();

        return new Veiculo(modelo, placa);
    }
    public static Cliente cadastraCliente(Scanner scan){
        String nome;
        String cnh;

        out.println("Cadastre o cliente");
        out.println("------------------");

        out.println("Digite 0 nome:");

        nome = scan.next();

        out.println("Digite a cnh:");

        cnh = scan.next();

        return new Cliente(nome, cnh);
    }

    public static Registro cadasTrarRegistro(Veiculo veiculo, String dataEntrada){
        return new Registro(veiculo , dataEntrada);
    }

}

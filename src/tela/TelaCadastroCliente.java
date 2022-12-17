package tela;

import BancoDeDados.Repositorio;
import entidade.Cliente;
import java.util.Scanner;

import static java.lang.System.out;

public class TelaCadastroCliente extends Tela{

    private static final Repositorio repositorio = Repositorio.getInstance();

    public static Cliente cadastrarCliente(Scanner scan){
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

}

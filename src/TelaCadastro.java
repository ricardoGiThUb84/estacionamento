import java.util.Scanner;

public class TelaCadastro {
    Veiculo veiculo;
    Cliente cliente;
    public static Veiculo cadastraVeiculo(Scanner scan){

        String modelo;
        String placa;


        System.out.println("Cadastre o veículo");
        System.out.println("------------------");

        System.out.println("Digite 0 modelo:");

        modelo = scan.next();

        System.out.println("Digite a placa:");

        placa = scan.next();

        return new Veiculo(modelo, placa);


    }
    public static Cliente cadastraCliente(Scanner scan){
        String nome;
        String cnh;

        System.out.println("Cadastre o cliente");
        System.out.println("------------------");

        System.out.println("Digite 0 nome:");

        nome = scan.next();

        System.out.println("Digite a cnh:");

        cnh = scan.next();

        return new Cliente(nome, cnh);


    }

}

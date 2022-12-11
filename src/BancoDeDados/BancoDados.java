package BancoDeDados;
import entidade.Cliente;
import entidade.Registro;
import entidade.Veiculo;
import java.util.ArrayList;
import java.util.Objects;


public class BancoDados {
    private ArrayList<Cliente> clientes;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Registro> registros;

    private static BancoDados instance;

    public static BancoDados getInstance(){
        if(Objects.isNull(instance)){
            instance = new BancoDados();
        }
        return instance;
    }
}

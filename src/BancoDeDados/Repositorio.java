package BancoDeDados;

import Utilitarios.ManipulaDatas;
import entidade.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Repositorio {
    private static Repositorio instance;

    private final ArrayList<Registro> listaRegistro = new ArrayList<>();
    private final ArrayList<Cliente> listaClientes= new ArrayList<>();
    private final ArrayList<Veiculo> listaVeiculos= new ArrayList<>();

    private Repositorio() {}

    public static Repositorio getInstance() {
        if(Objects.isNull(instance)) instance = new Repositorio();
      return instance;
    }

    public void  adicionarRegistro(Registro registro) {
        listaRegistro.add(registro);
    }

    public List<Registro> buscarRegistrosPorVeiculo(String placa){
        return listaRegistro.stream()
                .filter(buscaRegistro -> buscaRegistro.getVeiculo().getPlaca().equalsIgnoreCase(placa))
                .collect(Collectors.toList());
    }

    public Optional<Registro> buscarUltimoRegistroEntrada(String placa) {
        List<Registro> registros = buscarRegistrosPorVeiculo(placa);
        if(registros.size() % 2 == 0){
            return null;
        }else{
            return registros.stream()
                    .skip(registros.size() - 1)
                    .reduce((first, second) -> second);
        }
    }

    public void listarVeiculosEstacionados(){

        out.printf("%n***** Relatório de veículos estacionados em %s *****%n%n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        for(Veiculo veiculo : listaVeiculos){
            Optional<Registro> ultimaEntrada = buscarUltimoRegistroEntrada(veiculo.getPlaca());
            if(ultimaEntrada != null && ultimaEntrada.get().getTipoRegistro().equals(TipoRegistro.ENTRADA)){
                String duracao = ManipulaDatas.calculaTempoParcial(ultimaEntrada.get().getDataRegistro(), LocalDateTime.now());
                out.println(ultimaEntrada.get().imprimirSnapshot(duracao));
            }
        }
        out.println();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void  adicionarVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

    public void atualizarVeiculo(Veiculo veiculo, TipoPlano tipoPlano, int horas){
        for(Veiculo item : listaVeiculos){
            if(item.getPlaca().equals(veiculo.getPlaca())){
                item.setTipoPlano(tipoPlano);
                item.setSaldoHoras(horas);
            }
        }
    }

    public Optional<Veiculo> retornarDadosVeiculo(String placa){
        return listaVeiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)).findFirst();
    }

    public void  adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void retornarDados(String placa){
        out.println(listaRegistro.stream().filter(buscaRegistro -> buscaRegistro.getVeiculo().getPlaca().equalsIgnoreCase(placa) && buscaRegistro.getTipoRegistro().equals(TipoRegistro.SAIDA)).findFirst());
    }
}

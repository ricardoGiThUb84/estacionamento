package BancoDeDados;

import Utilitarios.ManipulaDatas;
import entidade.Cliente;
import entidade.Registro;
import entidade.TipoRegistro;
import entidade.Veiculo;
import exceptions.NaoExisteRegistroException;

import java.time.LocalDateTime;
import java.util.*;

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

    public void adiciona(Registro registro) {

        listaRegistro.add(registro);
    }

    public Registro buscaRegistroPorId(String placa) throws NaoExisteRegistroException {

        if(verificaSeHaRegistro(placa)){
            return listaRegistro.stream()
                    .filter(buscaRegistro -> buscaRegistro.getVeiculo().getPlaca()
                            .equalsIgnoreCase(placa)).findFirst().orElseThrow(() -> new NaoExisteRegistroException("Não há registro!"));
        }
        throw new NaoExisteRegistroException("Não há registro!");
    }

    public Optional<Registro> buscaRegistroEntrada(String placa) {
        return listaRegistro.stream()
                .filter(buscaRegistro -> buscaRegistro.getVeiculo().getPlaca().equalsIgnoreCase(placa)
                        && buscaRegistro.getTipoRegistro().equals(TipoRegistro.ENTRADA)).findFirst();
    }

    public boolean verificaSeHaRegistro(String placa) {
        return listaRegistro.stream()
                .anyMatch(registro -> registro.getVeiculo().getPlaca().equalsIgnoreCase(placa));
    }

    public void listaRegistrosComDataHoraSaidaParcial(String dataHoraParcial){

        LocalDateTime dataHoraMomentanea = ManipulaDatas.formatarStringDataEntradaUsuario(dataHoraParcial);

        listaRegistro.forEach(registro -> {
            if(registro.getTipoRegistro().equals(TipoRegistro.ENTRADA)){
                String duracao = ManipulaDatas.calculaTempoParcial(registro.getDataRegistro(), dataHoraMomentanea);
                //var valorParcial = registro.calculaValorMinuto(registro.getVeiculo(), dataHoraMomentanea);
                out.println(registro + " duração = " + duracao);
            }
        });
    }

//    public void listaRegistroComDataHoraSaida(String dataHoraParcial){
//
//        listaRegistro.forEach(registro -> {
//
//            registro.setDataHoraParcial(ManipulaDatas.calculaTempoParcial(registro.getHoraEntrada(), dataHoraParcial));
//            registro.calculaValorMinuto(registro.getHoraEntrada() , dataHoraParcial);
//            out.println(registro);
//
//        });
//    }


    @Override
    public String toString() {
        return super.toString();
    }

    public void  adicionarVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

    public Optional<Veiculo> retornarDadosVeiculo(String placa){
        return listaVeiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)).findFirst();
    }

    public void  adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void  adicionarRegistro(Registro registro) {
        listaRegistro.add(registro);
    }
    public Optional<LocalDateTime> retornarHoraEntrada(String placa) {
        return listaRegistro.stream()
                .filter(buscaRegistro -> buscaRegistro.getVeiculo().getPlaca().equalsIgnoreCase(placa) && buscaRegistro.getTipoRegistro().equals(TipoRegistro.ENTRADA))
                .map(Registro::getDataRegistro).findFirst();
    }

    public void retornarDados(){
        out.println(listaRegistro);
    }

    public void retornarDados(String placa){
        out.println(listaRegistro.stream().filter(buscaRegistro -> buscaRegistro.getVeiculo().getPlaca().equalsIgnoreCase(placa) && buscaRegistro.getTipoRegistro().equals(TipoRegistro.SAIDA)).findFirst());
    }
}

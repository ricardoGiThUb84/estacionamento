import Utilitarios.ManipulaDatas;
import exceptions.NaoExisteRegistroException;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Repositorio {
    private static Repositorio instance;

     private final List<Registro> listaRegistro = new ArrayList<>();

    
    private Repositorio() {}

    public static Repositorio getInstance() {
        if(Objects.isNull(instance)) instance = new Repositorio();
      return instance;
    }

    public void  adiciona(Registro registro) {

        listaRegistro.add(registro);
    }

    public Registro buscaRegistroPorId(String placa) throws NaoExisteRegistroException {

        if(verificaSeHaRegistro(placa)){
            return listaRegistro.stream()
                    .filter(buscaRegistro -> buscaRegistro.getId()
                            .equalsIgnoreCase(placa)).toList().get(0);
        }
        throw new NaoExisteRegistroException("Não há registro!");
    }

    public boolean verificaSeHaRegistro(String placa) {
        return listaRegistro.stream()
                .anyMatch(registro -> registro.getId().equalsIgnoreCase(placa));
    }

    public void listaRegistrosComDataHoraSaidaParcial(String dataHoraParcial){

        listaRegistro.forEach(registro -> {

           registro.setDataHoraParcial(ManipulaDatas.calculaTempoParcial(registro.getHoraEntrada(), dataHoraParcial));
           registro.calculaValorMinuto(registro.getHoraEntrada() , dataHoraParcial);
            out.println(registro);

        });
    }

    public void listaRegistroComDataHoraSaida(String dataHoraParcial){

        listaRegistro.forEach(registro -> {

            registro.setDataHoraParcial(ManipulaDatas.calculaTempoParcial(registro.getHoraEntrada(), dataHoraParcial));
            registro.calculaValorMinuto(registro.getHoraEntrada() , dataHoraParcial);
            out.println(registro);

        });
    }


    @Override
    public String toString() {
        return super.toString();
    }
}

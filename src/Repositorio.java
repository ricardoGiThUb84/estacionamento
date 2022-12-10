import Utilitarios.ManipulaDatas;

import java.util.*;

public class Repositorio {
    static private Repositorio instance;

     private List<Registro> listaRegistro = new ArrayList<>();

    
    private Repositorio() {}

    static public Repositorio getInstance() {
        if(Objects.isNull(instance)) instance = new Repositorio();
      return instance;
    }

    public void  adiciona(Registro registro) {

        listaRegistro.add(registro);
    }

    public void listaRegistrosComDataHoraSaidaParcial(String dataHoraParcial){

        listaRegistro.forEach(registro -> {

           registro.setDataHoraParcial(ManipulaDatas.calculaTempoParcial(registro.getHoraEntrada(), dataHoraParcial));
           registro.calculaValorMinuto(registro.getHoraEntrada() , dataHoraParcial);
            System.out.println(registro);

        });
    }

    public void listaRegistroComDataHoraSaida(String dataHoraParcial){

        listaRegistro.forEach(registro -> {

            registro.setDataHoraParcial(ManipulaDatas.calculaTempoParcial(registro.getHoraEntrada(), dataHoraParcial));
            registro.calculaValorMinuto(registro.getHoraEntrada() , dataHoraParcial);
            System.out.println(registro);

        });
    }


    @Override
    public String toString() {
        return super.toString();
    }
}

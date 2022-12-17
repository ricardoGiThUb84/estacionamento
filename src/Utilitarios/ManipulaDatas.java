package Utilitarios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class ManipulaDatas {
    private ManipulaDatas(){}

    static public LocalDateTime formatarStringDataEntradaUsuario(String dataHora){

        int[] data = Arrays.stream(dataHora.split("-")).mapToInt(Integer::parseInt).toArray();

        return LocalDateTime.of(data[2], data[1], data[0], data[3], data[4]);
    }

    static public long calculaDiferencaTempoHoras(LocalDateTime horaDataEntrada, LocalDateTime horaDataSaida){


        long calculoMinutos = horaDataEntrada.until(horaDataSaida, ChronoUnit.MINUTES);

        return Math.ceilDiv(calculoMinutos , 60);
    }
    public static String calculaTempoParcial(LocalDateTime dataHoraEntrada, LocalDateTime dataHoraMomentanea){

        long horas = calculaDiferencaTempoHoras(dataHoraEntrada, dataHoraMomentanea);

        return  horas + " hora(s)";
    }



}

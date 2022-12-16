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

    static public long calculaDiferencaTempoDias(LocalDateTime horaDataEntrada, LocalDateTime horaDataSaida){

        long diaria = horaDataEntrada.until(horaDataSaida, ChronoUnit.DAYS);

        if(diaria > 0) return diaria;
        return 0;
    }

    static public long calculaDiferencaTempoMinutos(LocalDateTime horaDataEntrada, LocalDateTime horaDataSaida){

        long dias = calculaDiferencaTempoDias(horaDataEntrada,horaDataSaida);
        long calculoMinutos = horaDataEntrada.until(horaDataSaida, ChronoUnit.MINUTES);

        return (dias >= 1 ) ? calculoMinutos - transformaDiasParaMinutos(dias) : calculoMinutos;
    }

    static public long transformaDiasParaMinutos(long dias){

        if(dias > 0) return dias * 1440;

        return 0;

    }

    public static String calculaTempoParcial(LocalDateTime dataHoraEntrada, LocalDateTime dataHoraMomentanea){
        int conversaoMinutoHora = 60;
        long dias = calculaDiferencaTempoDias(dataHoraEntrada , dataHoraMomentanea);
        long minutos = calculaDiferencaTempoMinutos(dataHoraEntrada, dataHoraMomentanea);
        int horas = 0;
        if (minutos >= conversaoMinutoHora){
            horas = (int)minutos/conversaoMinutoHora;
            minutos = minutos - horas * conversaoMinutoHora;
        }
        return (dias > 0 ? dias + " dia(s) " : "") + (horas > 0 ? horas + " hora(s) " : "") + minutos + " minuto(s).";
    }



}

package Utilitarios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class ManipulaDatas {
    private ManipulaDatas(){};

    static public LocalDateTime formatarStringDataEntradaUsuario(String dataHora){

        int[] data = Arrays.stream(dataHora.split("-")).mapToInt(Integer::parseInt).toArray();

        return LocalDateTime.of(data[2], data[1], data[0], data[3], data[4]);
    }

    static public long calculaDiferencaTempoDias(String entrada, String saida){

        LocalDateTime horaDataEntrada = formatarStringDataEntradaUsuario(entrada);
        LocalDateTime horaDataSaida = formatarStringDataEntradaUsuario(saida);

        long diaria = horaDataEntrada.until(horaDataSaida, ChronoUnit.DAYS);

        if(diaria > 0) return diaria;
        return 0;
    }

    static public long calculaDiferencaTempoMinutos(String entrada, String saida){

        LocalDateTime horaDataEntrada = formatarStringDataEntradaUsuario(entrada);
        LocalDateTime horaDataSaida = formatarStringDataEntradaUsuario(saida);

        long dias = calculaDiferencaTempoDias(entrada,saida);
        long calculoMinutos = horaDataEntrada.until(horaDataSaida, ChronoUnit.MINUTES);

        return (dias >= 1 ) ? calculoMinutos - transformaDiasParaMinutos(dias) : calculoMinutos;
    }

    static public long transformaDiasParaMinutos(long dias){

        if(dias > 0) return dias * 1440;

        return 0;

    }

    public static String calculaTempoParcial(String dataHoraEntrada, String dataHoraMomentanea){

        long dias = calculaDiferencaTempoDias(dataHoraEntrada , dataHoraMomentanea);
        long minutos = calculaDiferencaTempoMinutos(dataHoraEntrada, dataHoraMomentanea);
        return dias > 0 ? dias + " dia(s) " + "minuto(s) " + minutos : "minuto(s) " + minutos;
    }



}

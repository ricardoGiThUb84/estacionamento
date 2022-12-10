import Utilitarios.CalculoValores;
import Utilitarios.ManipulaDatas;

import java.util.Objects;

public class Registro implements CalculoValores {
    private String id;
    private Veiculo veiculo;
    private double valor;
    private final String horaEntrada;
    private String horaSaida;
    private String dataHoraParcial;

    public Registro(Veiculo veiculo, String dataEntrada) {
        this.veiculo = veiculo;
        this.id = veiculo.getPlaca();
        this.horaEntrada = dataEntrada;
    }

    public Veiculo getVeiculo() {
        return new Veiculo(veiculo.getModelo(), veiculo.getPlaca());
    }

    public void setHoraSaida(String horaSaida) {

        this.horaSaida = horaSaida;
    }
    public void setDataHoraParcial(String dataHoraParcial) {
        this.dataHoraParcial = dataHoraParcial;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public String getId() {
        return id;
    }

    @Override
    public void calculaValorMinuto(String dataHoraInicio, String dataHoraFim) {

        double minutos =  ManipulaDatas.calculaDiferencaTempoMinutos(dataHoraInicio, dataHoraFim);

        this.valor = (5 * minutos) / 60;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registro registro = (Registro) o;
        return Objects.equals(id, registro.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id='" + id + '\'' +
                ", veiculo=" + veiculo +
                ", valor=" + valor +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", dataHoraParcial='" + dataHoraParcial + '\'' +
                '}';
    }


}

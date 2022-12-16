package entidade;

import BancoDeDados.Repositorio;
import Utilitarios.ManipulaDatas;

import java.time.LocalDateTime;

public class RegistroSaida extends Registro {

    private double valor;

    public RegistroSaida(Veiculo veiculo, LocalDateTime dataRegistro) {
        super(veiculo, TipoRegistro.SAIDA, dataRegistro);
        calculaValorMinuto(veiculo, dataRegistro);
    }

    public double getValor() {
        return valor;
    }

    public void calculaValorMinuto(Veiculo veiculo, LocalDateTime dataHoraFim) {
        // TODO revisar o cálculo de horas (1hora = R$ 5 e desconto do plano)
        LocalDateTime dataHoraInicio = Repositorio.getInstance().retornarHoraEntrada(veiculo.getPlaca()).orElseThrow(() -> new RuntimeException("Não há registro de entrada para este veiculo!"));
        double minutos =  ManipulaDatas.calculaDiferencaTempoMinutos(dataHoraInicio, dataHoraFim);
        this.valor = (5 * minutos) / 60;
    }

    @Override
    public String toString() {
        return "entidade.Registro{" +
                "id='" + getVeiculo().getPlaca() + '\'' +
                ", veiculo=" + getVeiculo() +
                ", dataRegistro='" + getDataRegistro() + '\'' +
                ", tipoRegistro='" + getTipoRegistro() + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

}

package entidade;

import BancoDeDados.Repositorio;
import Utilitarios.ManipulaDatas;

import java.time.LocalDateTime;

public class RegistroSaida extends Registro {

    private static final Repositorio repositorio = Repositorio.getInstance();
    private double valor;

    public RegistroSaida(Veiculo veiculo, LocalDateTime dataRegistro) {
        super(veiculo, TipoRegistro.SAIDA, dataRegistro);
        calculaValorMinuto(veiculo, dataRegistro);
    }

    public double getValor() {
        return valor;
    }

    public void calculaValorMinuto(Veiculo veiculo, LocalDateTime dataHoraFim) {

        LocalDateTime dataHoraInicio = Repositorio.getInstance().retornarHoraEntrada(veiculo.getPlaca()).orElseThrow(() -> new RuntimeException("Não há registro de entrada para este veiculo!"));
        double hora =  ManipulaDatas.calculaDiferencaTempoHoras(dataHoraInicio, dataHoraFim);
        int horasPlano = veiculo.getSaldoHoras();

        if(horasPlano == 0){
            this.valor = (5 * hora);
        } else if (horasPlano >= hora){
            repositorio.atualizarVeiculo(veiculo, veiculo.getTipoPlano(), (int) -hora);
            this.valor = 0;
        } else if (horasPlano < hora){
            int saldoHoras = (int)hora - horasPlano;
            repositorio.atualizarVeiculo(veiculo, veiculo.getTipoPlano(), -horasPlano);
            this.valor = (5 * saldoHoras);
        }
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

package entidade;

import BancoDeDados.Repositorio;
import Utilitarios.CalculoValores;
import Utilitarios.ManipulaDatas;
import exceptions.NaoExisteRegistroException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Registro implements CalculoValores {
    private Veiculo veiculo;
    private double valor;
    private LocalDateTime dataRegistro;
    private TipoRegistro tipoRegistro;

    public Registro(Veiculo veiculo, TipoRegistro tipoRegistro){
        this.veiculo = veiculo;
        this.tipoRegistro = tipoRegistro;
        dataRegistro = LocalDateTime.now();
        if(tipoRegistro.equals(TipoRegistro.SAIDA)){
            calculaValorMinuto(veiculo, dataRegistro);
        }
    }

    public Registro(Veiculo veiculo, TipoRegistro tipoRegistro, String dataRegistro){
        this.veiculo = veiculo;
        this.tipoRegistro = tipoRegistro;
        this.dataRegistro = ManipulaDatas.formatarStringDataEntradaUsuario(dataRegistro);
        if(tipoRegistro.equals(TipoRegistro.SAIDA)){
            calculaValorMinuto(veiculo, this.dataRegistro);
        }
    }

    public Veiculo getVeiculo() {
        return new Veiculo(veiculo.getModelo(), veiculo.getPlaca());
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
    }

    @Override
    public void calculaValorMinuto(Veiculo veiculo, LocalDateTime dataHoraFim) {

        LocalDateTime dataHoraInicio = Repositorio.getInstance().retornarHoraEntrada(veiculo.getPlaca()).orElseThrow(() -> new RuntimeException("Não há registro de entrada para este veiculo!"));
        double minutos =  ManipulaDatas.calculaDiferencaTempoMinutos(dataHoraInicio, dataHoraFim);
        this.valor = (5 * minutos) / 60;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Registro registro = (Registro) o;
//        return Objects.equals(id, registro.id) ;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    @Override
    public String toString() {
        return "entidade.Registro{" +
                "id='" + veiculo.getPlaca() + '\'' +
                ", veiculo=" + veiculo +
                ", valor=" + valor +
                ", dataRegistro='" + dataRegistro + '\'' +
                ", tipoRegistro='" + tipoRegistro + '\'' +
                '}';
    }


}

package entidade;

import BancoDeDados.Repositorio;
import Utilitarios.CalculoValores;
import Utilitarios.ManipulaDatas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro implements CalculoValores {

    //TODO aplicar herança - criar dois filhos (entrada e saída)
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
    //TODO revisar o cálculo de horas (1hora = R$ 5 e desconto do plano)
    @Override
    public void calculaValorMinuto(Veiculo veiculo, LocalDateTime dataHoraFim) {

        LocalDateTime dataHoraInicio = Repositorio.getInstance().retornarHoraEntrada(veiculo.getPlaca()).orElseThrow(() -> new RuntimeException("Não há registro de entrada para este veiculo!"));
        double minutos =  ManipulaDatas.calculaDiferencaTempoMinutos(dataHoraInicio, dataHoraFim);
        this.valor = (5 * minutos) / 60;
    }

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

    public String imprimirSnapshot(String duracao){
        return String.format("Veículo - Placa: %s - Modelo: %s - Data de Entrada: %s - Duração Atual: %s",
                veiculo.getPlaca(), veiculo.getModelo(), dataRegistro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), duracao);
    }

}

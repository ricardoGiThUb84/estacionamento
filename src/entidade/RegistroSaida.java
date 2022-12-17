package entidade;

import BancoDeDados.Repositorio;
import Utilitarios.ManipulaDatas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        Registro dadosEntrada = repositorio.buscarUltimoRegistroEntrada(veiculo.getPlaca()).orElseThrow(() -> new RuntimeException("Não há registro de entrada para este veiculo!"));
        LocalDateTime dataHoraInicio = dadosEntrada.getDataRegistro();
        double hora =  ManipulaDatas.calculaDiferencaTempoHoras(dataHoraInicio, dataHoraFim);
        int horasPlano = veiculo.getSaldoHoras();

        if(horasPlano == 0){
            this.valor = (5 * hora);
            imprimirRegistro(dadosEntrada);
        } else if (horasPlano >= hora){
            repositorio.atualizarVeiculo(veiculo, veiculo.getTipoPlano(), (int) -hora);
            this.valor = 0;
            imprimirRegistro(dadosEntrada, horasPlano, (int)hora);
        } else if (horasPlano < hora){
            int saldoHoras = (int)hora - horasPlano;
            repositorio.atualizarVeiculo(veiculo, veiculo.getTipoPlano(), -horasPlano);
            this.valor = (5 * saldoHoras);
            imprimirRegistro(dadosEntrada, horasPlano, (int)hora, saldoHoras);
        }
    }

    public void imprimirRegistro(Registro dadosEntrada){
        System.out.printf("Veículo - Placa: %s - Modelo: %s %n\tData de Entrada: %s %n\tData da Saída: %s %n\tValor: R$ %.2f %n",
                getVeiculo().getPlaca(), getVeiculo().getModelo(), dadosEntrada.getDataRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), getDataRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), valor);
    }

    public void imprimirRegistro(Registro dadosEntrada, int horasPlano, int duracao){
        System.out.printf("Veículo - Placa: %s - Modelo: %s %n\tData de Entrada: %s %n\tData da Saída: %s %n\tSaldo de horas inicial: %d %n \tHoras descontadas: %d %n \tSaldo de horas atualizado: %d %n",
                getVeiculo().getPlaca(), getVeiculo().getModelo(), dadosEntrada.getDataRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), getDataRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), horasPlano, duracao, (horasPlano - duracao));
    }

    public void imprimirRegistro(Registro dadosEntrada, int horasPlano, int duracao, int saldoHoras){
        System.out.printf("Veículo - Placa: %s - Modelo: %s %n\tData de Entrada: %s %n\tData da Saída: %s %n\tSaldo de horas inicial: %d %n \tHoras descontadas: %d %n \tSaldo de horas atualizado: %d %n\tValor: R$ %.2f -> Referente ao saldo de %d horas %n",
                getVeiculo().getPlaca(), getVeiculo().getModelo(), dadosEntrada.getDataRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), getDataRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), horasPlano, (duracao - saldoHoras), 0, valor, saldoHoras);
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

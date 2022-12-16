package entidade;

import java.time.LocalDateTime;

public abstract class Registro {

    private Veiculo veiculo;
    private LocalDateTime dataRegistro;
    private TipoRegistro tipoRegistro;

    public Registro(Veiculo veiculo, TipoRegistro tipoRegistro, LocalDateTime dataRegistro){
        this.veiculo = veiculo;
        this.tipoRegistro = tipoRegistro;
        this.dataRegistro = dataRegistro;
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

    public String imprimirSnapshot(String duracao){
        return "";
    }

    @Override
    public String toString() {
        return "entidade.Registro{" +
                "id='" + veiculo.getPlaca() + '\'' +
                ", veiculo=" + veiculo +
                ", dataRegistro='" + dataRegistro + '\'' +
                ", tipoRegistro='" + tipoRegistro + '\'' +
                '}';
    }

}

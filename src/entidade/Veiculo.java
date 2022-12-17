package entidade;

public class Veiculo {

    private final String modelo;
    private final String placa;
    private Cliente condutor;
    private TipoPlano tipoPlano;
    private int saldoHoras;

    public Veiculo(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
        this.saldoHoras = 0;
    }

    public String getModelo() {

        return modelo;
    }

    public String getPlaca() {

        return placa;
    }

    public Cliente getCliente(){

        return new Cliente(condutor.getNome(), condutor.getCnh());
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public int getSaldoHoras() {
        return saldoHoras;
    }

    public void setCondutor(Cliente condutor) {

        this.condutor = condutor;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public void setSaldoHoras(int saldoHoras) {
        this.saldoHoras += saldoHoras;
    }

    @Override
    public String toString() {
        return "{" +
                "modelo:'" + modelo + '\'' +
                ", placa:'" + placa + '\'' +
                ", condutor:" + condutor +
                ", tipoPlano:" + (tipoPlano != null ? tipoPlano.getLabel() : "Nenhum") +
                ", saldoHoras:" + saldoHoras +
                '}';
    }
}

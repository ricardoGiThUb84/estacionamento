public class Veiculo {

    private final String modelo;
    private final String placa;

    private Cliente condutor;

    public Veiculo(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
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

    public void setCondutor(Cliente condutor) {

        this.condutor = condutor;
    }

    @Override
    public String toString() {
        return "{" +
                "modelo:'" + modelo + '\'' +
                ", placa:'" + placa + '\'' +
                ", condutor:" + condutor +
                '}';
    }
}

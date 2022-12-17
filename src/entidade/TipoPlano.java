package entidade;


public enum TipoPlano {

    PLANO15(1, "Plano 15 horas", 15, 50),
    PLANO30(2, "Plano 30 horas", 30, 100);

    private int opcao;
    private String label;
    private int horas;
    private double preco;

    private TipoPlano(int opcao, String label, int horas, double preco){
        this.opcao = opcao;
        this.label = label;
        this.horas = horas;
        this.preco = preco;
    }

    public int getOpcao() {
        return opcao;
    }

    public String getLabel() {
        return label;
    }

    public double getPreco() {
        return preco;
    }

    public int getHoras() {
        return horas;
    }

    public static TipoPlano fromOpcao(int opcao) {
        for (TipoPlano tipoPlano: TipoPlano.values()) {
            if(tipoPlano.getOpcao() == opcao){
                return tipoPlano;
            }
        }
        throw new RuntimeException("Opção inválida");
    }
}

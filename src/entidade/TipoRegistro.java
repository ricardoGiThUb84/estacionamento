package entidade;

public enum TipoRegistro {
    ENTRADA(1,"Entrada"), SAIDA(2, "Saída");

    private int opcao;
    private String label;

    private TipoRegistro(int opcao, String label){
        this.opcao = opcao;
        this.label = label;
    }

    public int getOpcao() {
        return opcao;
    }

    public String getLabel() {
        return label;
    }

    public static TipoRegistro fromOpcao(int opcao) {
        for (TipoRegistro tipoRegistro: TipoRegistro.values()) {
            if(tipoRegistro.getOpcao() == opcao){
                return tipoRegistro;
            }
        }
        throw new RuntimeException("Opção inválida");
    }
}

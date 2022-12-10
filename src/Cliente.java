public class Cliente {

    private String nome, cnh;

    public Cliente(String nome, String cnh) {
        this.nome = nome;
        this.cnh = cnh;
    }

    public String getNome() {
        return nome;
    }

    public String getCnh() {
        return cnh;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome:'" + nome + '\'' +
                ", cnh:'" + cnh + '\'' +
                '}';
    }
}

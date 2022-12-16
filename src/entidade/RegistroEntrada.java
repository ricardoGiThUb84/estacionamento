package entidade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroEntrada extends Registro {

    public RegistroEntrada(Veiculo veiculo) {
        super(veiculo, TipoRegistro.ENTRADA, LocalDateTime.now());
    }

    public String imprimirSnapshot(String duracao){
        return String.format("Veículo - Placa: %s - Modelo: %s - Data de Entrada: %s - Duração Parcial: %s",
                getVeiculo().getPlaca(), getVeiculo().getModelo(), getDataRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), duracao);
    }
}

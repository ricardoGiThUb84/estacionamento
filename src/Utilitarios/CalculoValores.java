package Utilitarios;

import entidade.Veiculo;

import java.time.LocalDateTime;

public interface CalculoValores {

     void calculaValorMinuto(Veiculo veiculo, LocalDateTime dataHoraFim);
}

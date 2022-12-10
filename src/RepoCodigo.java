//public class RepoCodigo {
//
//    public static void main(String[] args) {
//
//        package com.aulasdepoo.localdate;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.Month;
////import java.time.Period;
////import java.time.format.DateTimeFormatter;
//
//        public class ExemploLocalDate {
//
////            //recupera a data de hoje de acordo com o horário e data  do computador
////            static LocalDate dataHoje = LocalDate.now();
////
////            // Forma de escolher data
////            static LocalDate dataEscolhida = LocalDate.of(2020,01,30);
////            static LocalDate dataEscolhidaForma2 = LocalDate.of(2020, Month.JANUARY, 30);
////
////            //recuperar dia de uma data, mês e ano
////            static LocalDate data = LocalDate.now();
////            static int diaData = data.getDayOfMonth();
////            static int mesData = data.getMonthValue();
////            static int anoData = data.getYear();
////
////            //calcular diferença de um ano pra outro
////            static int anoNascimento = 1994;
////            static int idadeAnos = LocalDateTime.now().getYear() - anoNascimento;
////
////            //formatar data para formato brasileiro
////            static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////            static String dataHojeFormatado = dataHoje.format(formatter);
////
////            //calcular a duração entre duas datas
////            static LocalDate dataIncialPeriodo = LocalDate.of(1961, 04, 12);
////            static LocalDate dataFinalPeriodo = LocalDate.of(1969, 05, 25);
////            static Period periodoEntreDataInicialFinal = Period.between(dataIncialPeriodo, dataFinalPeriodo);
////
////            public static void main(String[] args) {
////                System.out.println("Data atual: " + dataHoje);
////                System.out.println("Data escolhida: " + dataEscolhida);
////                System.out.println("Recuperando dia da data de hoje: " + diaData);
////                System.out.println("Recuperando mês da data de hoje: " + mesData);
////                System.out.println("Recuperando ano da data de hoje: " + anoData);
////                System.out.println("LocalDate depois de formatar: " + dataHojeFormatado);
////                System.out.println("Data escolhida forma 2: " + dataEscolhidaForma2);
////                System.out.println("Período entre data inicial e data final:  " + periodoEntreDataInicialFinal.getYears()
////                        + " anos(s),  " + periodoEntreDataInicialFinal.getMonths() + " mes(es) e " + periodoEntreDataInicialFinal.getDays() + " dias.");
////                System.out.println("Idade em anos: " + idadeAnos);
////            }
////        }
////    }
//}

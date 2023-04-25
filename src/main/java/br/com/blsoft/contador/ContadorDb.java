/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blsoft.contador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author bruno.chagas
 */
public class ContadorDb implements ContadorRepository {

    private List<Counter> contadores = this.simularContadores();

    @Override
    public void salvar(Counter contador) {
        this.contadores.add(contador);
    }

    @Override
    public List<Counter> recuperarPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
//        List<Contador> contadoreEncontrados = new ArrayList<>();
//        for (Contador contador : contadores) {
//            if (contador.getDataRegistro().getMonthValue() >= dataInicio.getMonthValue()
//                    && contador.getDataRegistro().getMonthValue() <= dataFim.getMonthValue()) {
//                contadoreEncontrados.add(contador);
//            }
//        }
        List<Counter> contadoreEncontrados = 
                contadores.stream().filter(
                        contador -> contador.getDataRegistro().isAfter(dataInicio)
                )
                .collect(Collectors.toList());
        
        contadoreEncontrados = 
                contadores.stream().filter(
                        contador -> contador.getDataRegistro().isBefore(dataFim)
                )
                .collect(Collectors.toList());

        return contadoreEncontrados;
    }

    private List<Counter> simularContadores() {
        List<Counter> contadores = new ArrayList<>();
        Counter c = new Counter(100, 50, 50, LocalDate.of(2020, 8, 20));
        contadores.add(c);
        c = new Counter(150, 50, 50, LocalDate.of(2020, 9, 20));
        contadores.add(c);
        c = new Counter(150, 50, 50, LocalDate.of(2020, 10, 20));
        contadores.add(c);
        c = new Counter(150, 50, 50, LocalDate.of(2020, 9, 19));
        contadores.add(c);
        c = new Counter(150, 50, 50, LocalDate.of(2020, 9, 5));
        contadores.add(c);
        return contadores;
    }
}

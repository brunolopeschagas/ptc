/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blsoft.contador;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author bruno.chagas
 */
public interface ContadorRepository {
    public void salvar(Counter contador);
    public List<Counter> recuperarPorPeriodo(LocalDate dataInicio, LocalDate dataFim);
}

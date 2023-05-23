package br.com.blsoft.contador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;

/**
 *
 * @author bruno.chagas
 */
public class Counter {
    private long contTotal;
    private long contCopiadora;
    private long contImpressora;
    private LocalDate dataRegistro;

    public Counter(){}
    
    public Counter(long contTotal, long contCopiadora, long contImpressora, LocalDate dataRegistro) {
        this.contTotal = contTotal;
        this.contCopiadora = contCopiadora;
        this.contImpressora = contImpressora;
        this.dataRegistro = dataRegistro;
    }
    
    public LocalDate getDataRegistro() {
        if(null == dataRegistro){
            dataRegistro = LocalDate.now();
        }
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    
    public long getContTotal() {
        return contTotal;
    }

    public void setContTotal(long contTotal) {
        this.contTotal = contTotal;
    }

    public long getContCopiadora() {
        return contCopiadora;
    }

    public void setContCopiadora(long contCopiadora) {
        this.contCopiadora = contCopiadora;
    }

    public long getContImpressora() {
        return contImpressora;
    }

    public void setContImpressora(long contImpressora) {
        this.contImpressora = contImpressora;
    }

    @Override
    public String toString() {
        return "Total=" + contTotal + ", Copiadora=" + contCopiadora + ", Impressora=" + contImpressora;
    }
    
}

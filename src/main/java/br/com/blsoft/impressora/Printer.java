package br.com.blsoft.impressora;

import br.com.blsoft.contador.Counter;
import br.com.blsoft.contador.CounterParser;

public class Printer {
    private String name;
    private String ip;
    private String model;
    private Counter contador;
    private CounterParser counterParser;

    public Printer(String name, String ip, String model, CounterParser counterParser) {
        this.name = name;
        this.ip = ip;
        this.model = model;
        this.counterParser = counterParser;
    }

    public String getName() {
        return this.name;
    }

    public String getIp() {
        return this.ip;
    }

    public CounterParser getCounterParser() {
        return this.counterParser;
    }

    public Counter getContador() {
        return this.contador;
    }

    public void setCounter(Counter contador) {
        this.contador = contador;
    }

    public String getModel(){
        return this.model;
    }

    @Override
    public String toString() {
        return "IMPRESSORA " +
                " name='" + getName() + "'" +
                ", ip='" + getIp() + "'" +
                ", contador='" + getContador().toString() + "'" +
                "}";
    }
}

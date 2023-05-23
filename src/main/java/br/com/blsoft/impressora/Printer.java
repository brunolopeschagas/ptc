package br.com.blsoft.impressora;

import br.com.blsoft.contador.Counter;
import br.com.blsoft.contador.CounterParser;
import br.com.blsoft.estadoEquipamento.PrinterState;
import br.com.blsoft.estadoEquipamento.PrinterStateParser;

public class Printer {
    private String name;
    private String ip;
    private String model;
    private Counter contador;
    private PrinterState printerState;
 

    private CounterParser counterParser;
    private PrinterStateParser printerStateParser;

    public Printer(String name, String ip, String model, CounterParser counterParser) {
        this.name = name;
        this.ip = ip;
        this.model = model;
        this.counterParser = counterParser;
    }

    public Printer(String name, String ip, String model, CounterParser counterParser, PrinterStateParser printerStateParser) {
        this.name = name;
        this.ip = ip;
        this.model = model;
        this.counterParser = counterParser;
        this.printerStateParser = printerStateParser;
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

    public PrinterStateParser getStateParser(){
        return this.printerStateParser;
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

    public PrinterState getPrinterState() {
        return printerState;
    }

    public void setPrinterState(PrinterState printerState) {
        this.printerState = printerState;
    }

    @Override
    public String toString() {
        return "\nIMPRESSORA " +
                "" + getName() + "" +
                "\nIP ='" + getIp() + "'" +
                "\nContador ='" + getContador().toString() + "'" +
                "\n" + getPrinterState().toString() +
                "";
    }
}

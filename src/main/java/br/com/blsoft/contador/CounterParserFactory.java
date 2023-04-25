package br.com.blsoft.contador;

public class CounterParserFactory {
    public static CounterParser getCounterParser(String printerModel) {
        switch (printerModel) {
            case "im430":
                return new RicohIM430CounterParser();
            default:
                return new RicohIM430CounterParser();
        }
    }
}

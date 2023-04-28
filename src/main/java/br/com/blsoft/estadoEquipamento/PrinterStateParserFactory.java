package br.com.blsoft.estadoEquipamento;

public class PrinterStateParserFactory {
    public static PrinterStateParser getStateParser(String printerModel) {
        switch (printerModel) {
            case "im430":
                return new RicohIm430PrinterStateParser();
            default:
                return new RicohIm430PrinterStateParser();
        }
    }
}

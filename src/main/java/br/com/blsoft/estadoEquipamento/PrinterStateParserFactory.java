package br.com.blsoft.estadoEquipamento;

public class PrinterStateParserFactory {
    public static PrinterStateParser getStateParser(String printerModel) {
        switch (printerModel) {
            case "im430":
                return new RicohIm430PrinterStateParser();
            case "p6230cdn":
                return new KyoceraP6230cdnPrinterStateParser();
            default:
                return new KyoceraP6230cdnPrinterStateParser();
        }
    }
}

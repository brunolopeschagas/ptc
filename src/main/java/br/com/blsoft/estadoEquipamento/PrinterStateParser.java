package br.com.blsoft.estadoEquipamento;

import java.io.IOException;
import java.net.ConnectException;

public interface PrinterStateParser {
    public PrinterState getPrinterState(String urlFormatada) throws IOException, ConnectException ;
    public String getUrl(Boolean httpSecurity,  String printerIp, String language);
}

package br.com.blsoft.impressora;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

import br.com.blsoft.contador.Counter;
import br.com.blsoft.contador.CounterParser;
import br.com.blsoft.estadoEquipamento.PrinterState;
import br.com.blsoft.estadoEquipamento.PrinterStateParser;

public interface PrinterRepository {
    public List<Printer> getPrinters() throws IOException;
    public Counter getPrinterCounter(String ip, CounterParser counterParser, String language) throws ConnectException, IOException;
    public PrinterState getPrinterState(String ip, PrinterStateParser printerStateParser, String language) throws ConnectException, IOException;
}

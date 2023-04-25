package br.com.blsoft.impressora;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

import br.com.blsoft.contador.Counter;
import br.com.blsoft.contador.CounterParser;

public interface PrinterRepository {
    public List<Printer> getPrinters();
    public Counter getPrinterCounter(String ip, CounterParser counterParser) throws ConnectException, IOException;
}

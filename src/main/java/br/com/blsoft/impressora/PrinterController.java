package br.com.blsoft.impressora;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

import br.com.blsoft.contador.Counter;
import br.com.blsoft.contador.CounterParser;

public class PrinterController {

    private PrinterRepository printerRepository;

    public PrinterController(PrinterRepository printerRepository) {
        this.printerRepository = printerRepository;
    }

    public List<Printer> getPrinters() {
        return this.printerRepository.getPrinters();
    }

    public Counter getPrinterCounter(Printer printerToGetCounters) throws ConnectException, IOException {
        String printerIp = printerToGetCounters.getIp();
        CounterParser printerCounterParser = printerToGetCounters.getCounterParser();
        return this.printerRepository.getPrinterCounter(printerIp, printerCounterParser);
    }

}

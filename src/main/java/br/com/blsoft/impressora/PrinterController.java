package br.com.blsoft.impressora;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

import br.com.blsoft.contador.Counter;
import br.com.blsoft.contador.CounterParser;
import br.com.blsoft.estadoEquipamento.PrinterState;
import br.com.blsoft.estadoEquipamento.PrinterStateParser;

public class PrinterController {

    private PrinterRepository printerRepository;

    public PrinterController(PrinterRepository printerRepository) {
        this.printerRepository = printerRepository;
    }

    public List<Printer> getPrinters() throws IOException {
        return this.printerRepository.getPrinters();
    }

    public Counter getPrinterCounter(Printer printer, String language) throws ConnectException, IOException {
        String printerIp = printer.getIp();
        CounterParser printerCounterParser = printer.getCounterParser();
        return this.printerRepository.getPrinterCounter(printerIp, printerCounterParser, language);
    }

    public PrinterState getPrinterStatus(Printer printer, String language) throws ConnectException, IOException {
        String printerIp = printer.getIp();
        PrinterStateParser printerStateParser = printer.getStateParser();
        return this.printerRepository.getPrinterState(printerIp, printerStateParser, language);
    }

}

package br.com.blsoft.impressora;

import java.util.List;

public class PrinterController {

    private PrinterRepository printerRepository;

    public PrinterController(PrinterRepository printerRepository) {
        this.printerRepository = printerRepository;
    }

    public List<Printer> getPrinters() {
        return this.printerRepository.getPrinters();
    }
}

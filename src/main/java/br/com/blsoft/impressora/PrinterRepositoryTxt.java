package br.com.blsoft.impressora;

import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import br.com.blsoft.contador.Counter;
import br.com.blsoft.contador.CounterParser;
import br.com.blsoft.contador.CounterParserFactory;
import br.com.blsoft.estadoEquipamento.PrinterState;
import br.com.blsoft.estadoEquipamento.PrinterStateParser;
import br.com.blsoft.estadoEquipamento.PrinterStateParserFactory;
import br.com.blsoft.util.TxtReadWrite;

public class PrinterRepositoryTxt implements PrinterRepository {

    @Override
    public List<Printer> getPrinters() throws IOException {
        TxtReadWrite txtReadWrite = new TxtReadWrite("impressoras.txt");
        List<Printer> printers = new ArrayList<Printer>();
        List<String> fileLines = txtReadWrite.readFile();
        fileLines.forEach(line -> {
            Printer printer = printerFromTxtLine(line);
            printers.add(printer);
        });
        return printers;
    }

    private Printer printerFromTxtLine(String line) {
        String[] lineSplit = line.split(",");
        Printer printer = new Printer(lineSplit[0], lineSplit[1], lineSplit[2],
                CounterParserFactory.getCounterParser(lineSplit[2]), PrinterStateParserFactory.getStateParser(lineSplit[2]));
        return printer;
    }

    @Override
    public Counter getPrinterCounter(String ip, CounterParser counterParser, String language) throws ConnectException, IOException {
        String url = counterParser.getUrl(false, ip, language);
        Counter contador;
        contador = counterParser.getTotalCounters(url);
        return contador;
    }

    @Override
    public PrinterState getPrinterState(String ip, PrinterStateParser printerStateParser)
            throws ConnectException, IOException {
        String url = printerStateParser.getUrl(false, ip);
        PrinterState printerState = printerStateParser.getPrinterState(url);
        return printerState;
    }

}

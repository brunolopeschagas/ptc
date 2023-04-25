package br.com.blsoft.impressora;

import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import br.com.blsoft.TxtReadWrite;
import br.com.blsoft.contador.Counter;
import br.com.blsoft.contador.CounterParser;
import br.com.blsoft.contador.CounterParserFactory;

public class PrinterRepositoryTxt implements PrinterRepository {

    @Override
    public List<Printer> getPrinters() {
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
        Printer printer = new Printer(lineSplit[0], lineSplit[1], lineSplit[2], CounterParserFactory.getCounterParser(lineSplit[2]));
        return printer;
    }

    @Override
    public Counter getPrinterCounter(String ip, CounterParser counterParser) throws ConnectException, IOException {
        String url = counterParser.getUrl(false, ip);
        Counter contador;
        contador = counterParser.getTotalCounters(url);
        return contador;
    }

}

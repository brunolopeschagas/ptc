package br.com.blsoft.impressora;

import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import br.com.blsoft.TxtReadWrite;
import br.com.blsoft.contador.Contador;
import br.com.blsoft.contador.CounterParser;
import br.com.blsoft.contador.RicohIM430CounterParser;

public class PrinterTxt implements PrinterRepository {

    @Override
    public List<Printer> getPrinters() {
        TxtReadWrite txtReadWrite = new TxtReadWrite("impressoras.txt");
        List<Printer> printers = new ArrayList<Printer>();
        List<String> fileLines = txtReadWrite.readFile();
        fileLines.forEach(line -> {
            Printer printer = printerFromTxtLine(line);
            printers.add(printer);
        });
        printers.forEach(printer -> printer.setContador(printCounter(printer.getIp(), printer.getCounterParser())));
        return printers;
    }

    private Printer printerFromTxtLine(String line) {
        String[] lineSplit = line.split(",");
        Printer printer = new Printer(lineSplit[0], lineSplit[1], lineSplit[2], new RicohIM430CounterParser());
        return printer;
    }

    public Contador printCounter(String ip, CounterParser counterParser) {
        String url = counterParser.getUrl(false, ip);
        Contador contador;
        try {
            contador = counterParser.getContadorTotal(url);
            return contador;
        } catch (ConnectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}

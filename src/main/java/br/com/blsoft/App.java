package br.com.blsoft;

import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import br.com.blsoft.contador.Contador;
import br.com.blsoft.contador.CounterParser;
import br.com.blsoft.contador.RicohIM430CounterParser;
import br.com.blsoft.impressora.Printer;
import br.com.blsoft.impressora.PrinterController;
import br.com.blsoft.impressora.PrinterTxt;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws ConnectException, IOException {
        PrinterController printerController = new PrinterController(new PrinterTxt());
        List<Printer> printers = printerController.getPrinters();
        printers.forEach(System.out::println);
    }
}

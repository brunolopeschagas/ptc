package br.com.blsoft;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

import br.com.blsoft.contador.Counter;
import br.com.blsoft.impressora.Printer;
import br.com.blsoft.impressora.PrinterController;
import br.com.blsoft.impressora.PrinterRepositoryTxt;

public class App {
    public static void main(String[] args) {
        PrinterController printerController = new PrinterController(new PrinterRepositoryTxt());
        List<Printer> printers = printerController.getPrinters();
        printers.forEach(printer -> {
            new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("CONECTANDO À " + printer.getName() + "...");
                        Counter counter = printerController.getPrinterCounter(printer);
                        printer.setCounter(counter);
                        System.out.println("\n" + printer);
                    } catch (ConnectException e) {
                        System.out.println("NAO FOI POSSÍVEL CONECTAR A IMPRESSORA " + printer.getName());
                        // e.printStackTrace();
                    } catch (IOException e) {
                        System.out.println("ERRRO AO RECUPERAR OS CONTADORES DA IMPRESSORA " + printer.getName());
                        // e.printStackTrace();
                    }
                }
            }.start();
        });
    }
}

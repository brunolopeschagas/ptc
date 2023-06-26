package br.com.blsoft;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

import br.com.blsoft.contador.Counter;
import br.com.blsoft.estadoEquipamento.PrinterState;
import br.com.blsoft.impressora.Printer;
import br.com.blsoft.impressora.PrinterController;
import br.com.blsoft.impressora.PrinterRepositoryTxt;

public class ConsoleApp {

    public ConsoleApp() {
        PrinterController printerController = new PrinterController(new PrinterRepositoryTxt());
        List<Printer> printers;
        try {
            printers = printerController.getPrinters();
            printers.forEach(printer -> {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("CONECTANDO À " + printer.getName() + "...");
                            Counter counter = getCounters(printerController, printer);
                            printer.setCounter(counter);
                            PrinterState printerState = getStatus(printerController, printer);
                            printer.setPrinterState(printerState);
                            System.out.println("\n-------------------------------------------------------------");
                            System.out.println(printer);
                            printerState.getTonners().forEach(toner -> {
                                if (toner.getIsEmptyOrNear()) {
                                    System.out.println("\n este tonner " + toner.getColor() + " está quase vazio");
                                    ;
                                }
                            });
                        } catch (ConnectException e) {
                            System.out.println("\n\nNAO FOI POSSÍVEL CONECTAR A IMPRESSORA " + printer.getName());
                            // e.printStackTrace();
                        } catch (IOException e) {
                            System.out
                                    .println("\n\nERRRO AO RECUPERAR OS CONTADORES DA IMPRESSORA " + printer.getName() + " - ");
                                    e.printStackTrace();
                            // e.printStackTrace();
                        }
                    }

                    private Counter getCounters(PrinterController printerController, Printer printer)
                            throws ConnectException, IOException {
                        Counter counter = printerController.getPrinterCounter(printer, printer.getLanguage());
                        return counter;
                    }

                    private PrinterState getStatus(PrinterController printerController, Printer printer)
                            throws ConnectException, IOException {
                        PrinterState printerState = printerController.getPrinterStatus(printer, printer.getLanguage());
                        return printerState;
                    }
                }.start();
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

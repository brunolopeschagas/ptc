package br.com.blsoft.estadoEquipamento;

import java.util.ArrayList;
import java.util.List;

public class PrinterState {
    private List<Tonner> tonners;

    public PrinterState() {
        this.tonners = new ArrayList<>();
    }

    public PrinterState(List<Tonner> tonners) {
        this.tonners = tonners;
    }

    public void addTonner(Tonner tonner) {
        this.tonners.add(tonner);
    }

    public List<Tonner> getTonners() {
        return this.tonners;
    }

}

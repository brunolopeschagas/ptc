package br.com.blsoft.estadoEquipamento;

public class Tonner {
    private String color;
    private int statusPercentage;
    private boolean isEmptyOrNear;

    public Tonner(String color, int statusPercentage, boolean isEmptyOrNear) {
        this.color = color;
        this.statusPercentage = statusPercentage;
        this.isEmptyOrNear = isEmptyOrNear;
    }

    public String getColor() {
        return this.color;
    }

    public int getStatusPercentage() {
        return this.statusPercentage;
    }

    public boolean getIsEmptyOrNear() {
        return this.isEmptyOrNear;
    }

    public boolean isIsEmptyOrNear() {
        return this.isEmptyOrNear;
    }

}

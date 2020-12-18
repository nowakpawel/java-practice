package pl.nowak.pawel.java.generics;

import java.math.BigDecimal;

public class Truck extends Car {
    private Double tonnage;

    public Truck(String year, String model, String manufacturer, Double price, Double tonnage) {
        super(year, model, manufacturer, price);
        this.tonnage = tonnage;
    }
}

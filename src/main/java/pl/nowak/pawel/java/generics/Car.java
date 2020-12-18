package pl.nowak.pawel.java.generics;

import java.math.BigDecimal;

public class Car {
    private String year;
    private String model;
    private String manufacturer;
    private Double price;

    public Car() {
    }

    public Car(String year, String model, String manufacturer, Double price) {
        this.year = year;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "year='" + year + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }
}

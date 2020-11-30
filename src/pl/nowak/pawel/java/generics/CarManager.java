package pl.nowak.pawel.java.generics;

import java.util.ArrayList;
import java.util.List;

//public class CarManager<T extends Car> {
public class CarManager<T> {
    private List<T> carList = new ArrayList<>();// when I used just List without Constructor I had null pointer exception

    public void addCar(T t) {
        carList.add(t);
    }

    public T removeCar(T t) {

            carList.remove(t);
            return t;
        }

    public List<T> getCarList() {
        return carList;
    }
}

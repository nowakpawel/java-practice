package pl.nowak.pawel.java.generics;

import java.util.ArrayList;
import java.util.List;

public class CarManager<T extends Car> {
    private ArrayList<T> carList = new ArrayList<>();// when I used just List without Constructor I had null pointer exception

    public void addCar(T t) throws NullPointerException {
        if (t != null) {
            carList.add(t);
        }
    }

    public T removeCar(T t) {
        if (carList.isEmpty()) {
            return null;
        } else {
            carList.remove(t);
            return t;
        }
    }

    public List<T> getCarList() {
        return carList;
    }
}

package pl.nowak.pawel.java.generics;

public class StudentConverter<T> {
    public String information(T t) {
        System.out.println("Information");
        System.out.println(t);

        return t.toString();
    }
}

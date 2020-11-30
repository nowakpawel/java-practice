package pl.nowak.pawel.java.generics;

public interface Mapper<I, O> {// I- input, O - output
    O map(I input);
}

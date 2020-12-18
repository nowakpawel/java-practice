package pl.nowak.pawel.java.crud.service.mapper;

public class CalculatorMain {
    public static void main(String[] args) {
        DefaultCalculator defaultCalculator = new DefaultCalculator();
        defaultCalculator.calculate((a, b) -> a + b);
        defaultCalculator.calculate((a,b) -> Integer.sum(a, b));
        defaultCalculator.calculate(Integer::sum);
    }
}

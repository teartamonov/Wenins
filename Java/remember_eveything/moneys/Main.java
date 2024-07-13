package moneys;

public class Main {
    public static void main(String[] args) {
    Money m1 = new Money(12, 123);
    Money m2 = new Money(9, 88);
    m1.add(m2).get_money();
    m1.subtract(m2).get_money();
    m1.multiply(m2).get_money();
    m1.divide(m2).get_money();


    }
}
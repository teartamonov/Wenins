package fractures;


public class Main {
    public static void main(String[] args) {
        Fracture f1 = new Fracture(2, 3);
        Fracture f2 = new Fracture(1, 3);
        Fracture f3 = f1.add(f2);
        f3.show_frac();
        f3 = f3.add(f2);
        f3.show_frac();
        f3 = f3.add(new Fracture(4, 6));
        f3.show_frac();
        f3 = f3.subtract(f1);
        f3.show_frac();
        f3.multiply(f1).show_frac();
        f3.divide(f1).show_frac();

    }
}
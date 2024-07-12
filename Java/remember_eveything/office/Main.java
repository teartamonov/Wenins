import workers.Accountant;
import workers.Programmer;

public class Main {
    public static void main(String[] args) {
        Programmer Ivan = new Programmer("Ivan", 10);
        Accountant Alesya = new Accountant("Alesya");
        Ivan.show_capital();
        Ivan.code();
        Alesya.show_capital();
        Alesya.count_fees(Ivan);
        Ivan.show_capital();
        Alesya.show_capital();
        Ivan.say_my_name();
    }
}
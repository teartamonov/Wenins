package office.workers;

public class Accountant extends Worker {
    public Accountant(String name){
        this.name = name;
        fee = 60000;
        capital = 500000;
    }

    public void report(){
        System.out.println("I am done with fees");
    }

    public void count_fees(Programmer WantMoney){
        this.capital -= WantMoney.fee;
        WantMoney.capital += WantMoney.fee;
    }
}


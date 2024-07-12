package office.workers;

public class Programmer extends Worker {

    public Programmer(String name, int capital){
        this.name = name;
        this.capital = capital;
        this.fee = 90000;
    }

    public void report(){
        System.out.println("My code is done.");
    }

    public void code(){
        System.out.println("I am coding some stuff...");
    }

}

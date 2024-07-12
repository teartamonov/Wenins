package workers;

abstract public class Worker{
    String name;
    int fee;
    int capital;
    public abstract void report();
    public void show_capital(){
        System.out.println(this.capital);
    }
    public void say_my_name(){
        System.out.println("My name is " + this.name);
    }
}
package fractures;

public class Fracture {
    private int numerator;
    private int denominator;

    public Fracture(){}
    public Fracture(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private Fracture reduce_frac(){
        int reduce = My_math.find_GCD(this.numerator, this.denominator);
        return new Fracture(this.numerator/reduce, this.denominator/reduce);
    }

    public Fracture add(Fracture frac){
        int num, den;
        if (this.denominator != frac.denominator) {
            num = this.numerator * frac.denominator + frac.numerator * this.denominator;
            den = this.denominator * frac.denominator;
        }
        else {
            num = this.numerator + frac.numerator;
            den = this.denominator;
        }
        return new Fracture(num, den).reduce_frac();
    }

    public Fracture subtract(Fracture frac){
        int num, den;
        if (this.denominator != frac.denominator) {
            num = this.numerator * frac.denominator - frac.numerator * this.denominator;
            den = this.denominator * frac.denominator;
        }
        else {
            num = this.numerator + frac.numerator;
            den = this.denominator;
        }
        return new Fracture(num, den).reduce_frac();
    }

    public Fracture multiply(Fracture frac){
        int num, den;
        num = this.numerator * frac.numerator;
        den = this.denominator * frac.denominator;
        return new Fracture(num, den).reduce_frac();
    }

    public Fracture divide(Fracture frac){
        int num, den;
        num = this.numerator * frac.denominator;
        den = this.denominator * frac.numerator;
        return new Fracture(num, den).reduce_frac();
    }

    public void show_frac(){
        System.out.println(this.numerator + "/" + this.denominator);
    }


}

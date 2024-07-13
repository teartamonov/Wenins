package moneys;

public class Money {
    private long left;
    private int right;

    public Money(long left, int right){
        this.right = right;
        this.left = left;
    }
    public void get_money(){
        System.out.println(this.left + "." + this.right);
    }
    public Money add(Money money){
        long l = this.left + money.left;
        int r;
        int len1 = String.valueOf(this.right).length();
        int len2 = String.valueOf(money.right).length();
        if (len1 > len2) r = (int)(money.right * Math.pow(10, len1 - len2) + this.right);
        else r = (int)(this.right * Math.pow(10, len2 - len1) + money.right);
        int lenr = String.valueOf(r).length();
        if (lenr > Math.max(len1, len2)) {
            l+=1;
            r = (int)(r % Math.pow(10, lenr - 1));
        }
        return new Money(l,r);
    }
    public Money subtract(Money money){
        long l = this.left - money.left;
        int r;
        int len1 = String.valueOf(this.right).length();
        int len2 = String.valueOf(money.right).length();
        if (len1 > len2) r = (int)(this.right - money.right * Math.pow(10, len1 - len2));
        else r = (int)(this.right * Math.pow(10, len2 - len1) - money.right);
        int lenr = String.valueOf(r).length();
        if (r < 0) {
            l-=1;
            r = (int)(Math.pow(10, lenr-1)) + r;
        }
        return new Money(l,r);
    }
    public Money multiply(Money money){
        long l;
        int r1, r2;
        int r;
        long tmp = 0;
        int len1 = String.valueOf(this.right).length();
        int len2 = String.valueOf(money.right).length();
        if (len1 > len2) {
            r1 = this.right;
            r2 = (int) (money.right * Math.pow(10, len1 - len2));
            tmp = (this.left * (int)(Math.pow(10, len1)) + r1) * (money.left * (int)(Math.pow(10, len1)) + r2);
        }
        else {
            r1 = (int)(this.right * Math.pow(10, len2 - len1));
            r2 = money.right;
            tmp = (this.left * (int)(Math.pow(10, len2)) + r1) * (money.left * (int)(Math.pow(10, len2)) + r2);
        }
        l = (long)(tmp/Math.pow(10, 2*len1));
        r = (int)(tmp % (Math.pow(10, 2*len1)));

        return new Money(l,r);
    }
    public Money divide(Money money){
        long l;
        int r1, r2;
        int r;
        double tmp;
        int len1 = String.valueOf(this.right).length();
        int len2 = String.valueOf(money.right).length();
        if (len1 > len2) {
            r1 = this.right;
            r2 = (int) (money.right * Math.pow(10, len1 - len2));
            double dividend = (this.left * Math.pow(10, len1) + r1);
            double divider = (money.left * Math.pow(10, len1) + r2);
            tmp = dividend / divider;
        }
        else {
            r1 = (int)(this.right * Math.pow(10, len2 - len1));
            r2 = money.right;
            double dividend = (this.left * Math.pow(10, len2) + r1);
            double divider = (money.left * Math.pow(10, len2) + r2);
            tmp = dividend / divider;
        }
        l = (long)(tmp);
        r = (int)((tmp - l)*Math.pow(10,6));

        return new Money(l,r);
    }
}

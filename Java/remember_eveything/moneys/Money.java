package moneys;

public class Money {
    long left;
    int right;

    public Money(long left, int right){
        this.right = right;
        this.left = left;
    }

    public Money add(Money money){
        long l = this.left + money.left;
        int r;
        int len1 = String.valueOf(this.right).length();
        int len2 = String.valueOf(money.right).length();
        if (len1 > len2) r = (int)(money.right * Math.pow(10, len1 - len2) + this.right);
        else r = (int)(this.right * Math.pow(10, len2 - len1) + money.right);
        if (String.valueOf(r).length() > Math.max(len1, len2)) l+=1;
        return new Money(l,r);
    }
    public Money subtract(Money money){
        long l = this.left - money.left;
        int r;
        int len1 = String.valueOf(this.right).length();
        int len2 = String.valueOf(money.right).length();
        if (len1 > len2) r = (int)(this.right - money.right * Math.pow(10, len1 - len2));
        else r = (int)(this.right * Math.pow(10, len2 - len1) - money.right);
        if (r < 0) l-=1;
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
            tmp = (this.left * len1 + r1) * (money.left * len1 + r2);
        }
        else {
            r1 = (int)(this.right * Math.pow(10, len2 - len1));
            r2 = money.right;
            tmp = (this.left * len2 + r1) * (money.left * len2 + r2);
        }
        l = (long)(tmp/Math.pow(10, 2*len1));
        r = (int)(tmp % (Math.pow(10, 2*len1)));

        return new Money(l,r);
    }
    public Money divide(Money money){
        long l;
        int r1, r2;
        int r;
        long tmp = 0;
        int len1 = String.valueOf(this.right).length();
        int len2 = String.valueOf(money.right).length();
        if (len1 > len2) {
            r1 = this.right;
            r2 = (int) (money.right * Math.pow(10, len1 - len2));
            tmp = (this.left * len1 + r1) / (money.left * len1 + r2);
        }
        else {
            r1 = (int)(this.right * Math.pow(10, len2 - len1));
            r2 = money.right;
            tmp = (this.left * len2 + r1) / (money.left * len2 + r2);
        }
        double t = Math.pow(10, 2*Math.max(len1,len2));
        l = (long)(tmp/t);
        r = (int)(tmp % (t));

        return new Money(l,r);
    }
}

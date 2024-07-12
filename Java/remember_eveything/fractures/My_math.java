package fractures;

public class My_math {
    public static int find_GCD(int a, int b){
        int gcd = 0;
        if (a == b) gcd = a;
        else if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        for (int i = a; i > 0; i--){
            if (b % i == 0 && a % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }
}

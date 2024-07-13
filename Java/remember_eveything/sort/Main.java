package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 4, 6, 5};
        SortAlgs.quick_sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
        int[] b = {3, 2, 1, 4, 6, 5};
        SortAlgs.bubble_sort(b);
        System.out.println(Arrays.toString(b));
        int[] c = {3, 2, 1, 4, 6, 5};
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
    }
}
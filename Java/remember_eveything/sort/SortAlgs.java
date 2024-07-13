package sort;


public class SortAlgs {
    //O(n log n)
    public static void quick_sort(int[] array, int bot, int top){
        int mid = bot + (top - bot) / 2;
        int i = bot;
        int j = top;
        while (i <= j) {
            while (array[i] < array[mid]) ++i;
            while (array[j] > array[mid]) --j;
            if (i <= j) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                ++i;
                --j;
            }
            if (bot < j) quick_sort(array, bot, mid);
            if (top > i) quick_sort(array, mid, top);
        }
    }
    //O(n2)
    public static void bubble_sort(int[] array){
        for (int i = 0; i < array.length; ++i){
            for (int j = 0; j < array.length; ++j){
                if (array[i] < array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }
}

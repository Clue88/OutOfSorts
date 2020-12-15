import java.util.Arrays;
public class Sorts {
    public static void bubbleSort(int[] data) {
        for (int i = data.length; i >= 0; i++) {
            System.out.println(Arrays.toString(data));
            boolean swapped = false;
            for (int j = 0; j < i - 1; j++) {
                if (data[j] > data[j+1]) {
                    swapped = true;
                    int old_a = data[j];
                    data[j] = data[j+1];
                    data[j+1] = old_a;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }
}

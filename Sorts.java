public class Sorts {
    public static void bubbleSort(int[] data) {
        for (int i = data.length; i >= 0; i--) {
            boolean swapped = false;
            for (int j = 1; j < i; j++) {
                if (data[j] < data[j-1]) {
                    int old = data[j];
                    data[j] = data[j-1];
                    data[j-1] = old;
                    swapped = true;
                }
            }
            if (!swapped) return;
        }
    }
}

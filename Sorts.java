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

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int smallest_ind = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[smallest_ind]) {
                    smallest_ind = j;
                }
            }
            int old = data[i];
            data[i] = data[smallest_ind];
            data[smallest_ind] = old;
        }
    }

    public static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int old = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > old) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = old;
        }
    }
}

import java.util.Arrays;
import java.util.Random;
public class Tester {
    public static int ERR = 0;
    public static boolean DEBUG = true;
    public static void main(String[] args) {
        if (args.length > 0 && Boolean.parseBoolean(args[0]) == false) DEBUG = false;
        String test = "";

        test = "Sorts.bubbleSort(int[] data)";
        try {
            int[] a = {5, 1, 12, -5, 16};
            int[] b = {2, 3, 4, 5, 1};
            int[] c = {6, 1, 2, 3, 4, 5}; 
            Sorts.bubbleSort(a);
            Sorts.bubbleSort(b);
            Sorts.bubbleSort(c);
            check(test, Arrays.toString(a), "[-5, 1, 5, 12, 16]");
            check(test, Arrays.toString(b), "[1, 2, 3, 4, 5]");
            check(test, Arrays.toString(c), "[1, 2, 3, 4, 5, 6]");

            Random rng = new Random();
            for (int i = 0; i < 100; i++) {
                int seed = rng.nextInt();
                int[] arSort = new int[10];
                int[] arOrig = new int[10];
                Random rand = new Random(seed);
                for (int j = 0; j < 10; j++) {
                    int num = rand.nextInt() % 1000;
                    arSort[j] = num;
                    arOrig[j] = num;
                }
                Sorts.bubbleSort(arSort);
                Arrays.sort(arOrig);
                check(test, Arrays.toString(arSort), Arrays.toString(arOrig), seed);
            }
        } catch(RuntimeException e) {
            except(test, e);
        }

        if (ERR == 0) System.out.println("All good!");
        else if (ERR == 1) System.out.println("Uh oh... 1 error found.");
        else System.out.println("Uh oh... " + ERR + " errors found.");
    }

    public static void check(String test, Object actual, Object expected) {
        if (!actual.equals(expected)) {
            System.out.println("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            ERR++;
        }
    }

    public static void check(String test, Object actual, Object expected, int seed) {
        if (!actual.equals(expected)) {
            System.out.print("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            if (DEBUG) System.out.println(" Seed: " + seed);
            else System.out.println();
            ERR++;
        }
    }

    public static void except(String test, RuntimeException e) {
        System.out.println("Failure on " + test + ": RuntimeException");
        if (DEBUG) System.out.println(e.toString());
        ERR++;
    }

    public static void noException(String test, String expected) {
        System.out.println("Failure on " + test + ": Expected " + expected);
        ERR++;
    }

    public static void nothing(Object... nothings) {
        return;
    }
}

/******************************************************************************
 *  Compilation:  javac Tester.java
 *  Execution:    java Tester [numTests=NUM_TESTS] [arraySize=ARRAY_SIZE]
 *
 *  numTests: The number of trials per sorting method used.
 *  arraySize: The size of arrays used per trial.
 ******************************************************************************/

import java.util.Arrays;
import java.util.Random;
public class Tester {
    public static int ERR = 0;
    public static boolean DEBUG = true;
    public static void main(String[] args) {
        if (args.length > 0 && Boolean.parseBoolean(args[0]) == false) DEBUG = false;
        String test = "";
        int numTests = 100;
        int arraySize = 10;

        for (int i = 0; i < args.length; i++) {
            if (args[i].split("=")[0].equals("numTests")) {
                numTests = Integer.parseInt(args[i].split("=")[1]);
            }
            if (args[i].split("=")[0].equals("arraySize")) {
                arraySize = Integer.parseInt(args[i].split("=")[1]);
            }
        }

        test = "Sorts.bubbleSort(int[] data)";
        try {
            int[] a = {5, 1, 12, -5, 16};
            int[] b = {2, 3, 4, 5, 1};
            int[] c = {6, 1, 2, 3, 4, 5};
            int[] d = {};
            Sorts.bubbleSort(a);
            Sorts.bubbleSort(b);
            Sorts.bubbleSort(c);
            Sorts.bubbleSort(d);
            check(test, Arrays.toString(a), "[-5, 1, 5, 12, 16]");
            check(test, Arrays.toString(b), "[1, 2, 3, 4, 5]");
            check(test, Arrays.toString(c), "[1, 2, 3, 4, 5, 6]");
            check(test, Arrays.toString(d), "[]");

            Random rng = new Random();
            for (int i = 0; i < numTests; i++) {
                int seed = rng.nextInt();
                int[] arSort = new int[arraySize];
                int[] arOrig = new int[arraySize];
                Random rand = new Random(seed);
                for (int j = 0; j < arraySize; j++) {
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

        test = "Sorts.selectionSort(int[] data)";
        try {
            int[] a = {5, 1, 12, -5, 16};
            int[] b = {2, 3, 4, 5, 1};
            int[] c = {6, 1, 2, 3, 4, 5};
            int[] d = {};
            Sorts.selectionSort(a);
            Sorts.selectionSort(b);
            Sorts.selectionSort(c);
            Sorts.selectionSort(d);
            check(test, Arrays.toString(a), "[-5, 1, 5, 12, 16]");
            check(test, Arrays.toString(b), "[1, 2, 3, 4, 5]");
            check(test, Arrays.toString(c), "[1, 2, 3, 4, 5, 6]");
            check(test, Arrays.toString(d), "[]");

            Random rng = new Random();
            for (int i = 0; i < numTests; i++) {
                int seed = rng.nextInt();
                int[] arSort = new int[arraySize];
                int[] arOrig = new int[arraySize];
                Random rand = new Random(seed);
                for (int j = 0; j < arraySize; j++) {
                    int num = rand.nextInt() % 1000;
                    arSort[j] = num;
                    arOrig[j] = num;
                }
                Sorts.selectionSort(arSort);
                Arrays.sort(arOrig);
                check(test, Arrays.toString(arSort), Arrays.toString(arOrig), seed);
            }
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "Sorts.insertionSort(int[] data)";
        try {
            int[] a = {5, 1, 12, -5, 16};
            int[] b = {2, 3, 4, 5, 1};
            int[] c = {6, 1, 2, 3, 4, 5};
            int[] d = {};
            Sorts.insertionSort(a);
            Sorts.insertionSort(b);
            Sorts.insertionSort(c);
            Sorts.insertionSort(d);
            check(test, Arrays.toString(a), "[-5, 1, 5, 12, 16]");
            check(test, Arrays.toString(b), "[1, 2, 3, 4, 5]");
            check(test, Arrays.toString(c), "[1, 2, 3, 4, 5, 6]");
            check(test, Arrays.toString(d), "[]");

            Random rng = new Random();
            for (int i = 0; i < numTests; i++) {
                int seed = rng.nextInt();
                int[] arSort = new int[arraySize];
                int[] arOrig = new int[arraySize];
                Random rand = new Random(seed);
                for (int j = 0; j < arraySize; j++) {
                    int num = rand.nextInt() % 1000;
                    arSort[j] = num;
                    arOrig[j] = num;
                }
                Sorts.insertionSort(arSort);
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

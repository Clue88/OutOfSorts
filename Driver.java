import java.util.Arrays;
import java.util.Random;
public class Driver {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Driver SIZE ALGO [STYLE]");
            System.out.println("Supported ALGO: bubble, selection, insertion, test");
            System.out.println("Supported STYLE: random, equal, sorted, revered");
        } else {
            int[] randData = new int[Integer.parseInt((args[0]))];
            Random rng = new Random();

            if (args.length < 3 || args[2].equals("random")) {
                for (int i = 0; i < randData.length; i++) {
                    randData[i] = rng.nextInt() % 1000;
                }
            } else if (args[2].equals("equal")) {
                int constant = rng.nextInt() % 1000;
                for (int i = 0; i < randData.length; i++) {
                    randData[i] = constant;
                }
            } else if (args[2].equals("sorted")) {
                int constant = Math.abs(rng.nextInt() % 50);
                for (int i = 0; i < randData.length; i++) {
                    randData[i] = i * constant;
                }
            } else if (args[2].equals("reversed")) {
                int constant = Math.abs(rng.nextInt() % 50);
                for (int i = 0; i < randData.length; i++) {
                    randData[i] = (randData.length - i) * constant;
                }
            }

            if (args[1].equals("bubble")) {
                Sorts.bubbleSort(randData);
            } else if (args[1].equals("selection")) {
                Sorts.selectionSort(randData);
            } else if (args[1].equals("insertion")) {
                Sorts.insertionSort(randData);
            } else if (args[1].equals("test")) {
                int[] randDataBubble = Arrays.copyOf(randData,randData.length);
                int[] randDataSelection = Arrays.copyOf(randData,randData.length);
                int[] randDataInsertion = Arrays.copyOf(randData,randData.length);
                Arrays.sort(randData);
                Sorts.bubbleSort(randDataBubble);
                Sorts.selectionSort(randDataSelection);
                Sorts.insertionSort(randDataInsertion);

                if (Arrays.equals(randData, randDataBubble)) {
                    System.out.println("Bubble Correct!");
                } else {
                    System.out.println("Bubble Not Correct!!!!!!!!!11oneeleven");
                }

                if (Arrays.equals(randData, randDataSelection)) {
                    System.out.println("Selection Correct!");
                } else {
                    System.out.println("Selection Not Correct!!!!!!!!!11oneeleven");
                }

                if (Arrays.equals(randData, randDataInsertion)) {
                    System.out.println("Insertion Correct!");
                } else {
                    System.out.println("Insertion Not Correct!!!!!!!!!11oneeleven");
                }
            }
        }
    }
}

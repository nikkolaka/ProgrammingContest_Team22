import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/* These problems were for the Puget Sound Spring Programming Contest
The competition was for High-school students up-to undergraduate seniors in teams of three.
It was run by Professor Tom Capaul and Professor Chris Marriot.

* Our team was Number 22 and on our team we had:
* James R Deal
* Luke McAlpine
* Nicholas Zhuk
*
* */


/* A number N of ducks swim in a circle on a pond, and the resident alligator decides to eat
a duck at a regular interval M, i. e., every Mth duck that swims by. After any duck has been
eaten, the remaining flustered ducks close the circle and reverse the direction in which they
swim. The ?gator again eats the Mth duck that swims by. This is repeated until the hungry
reptile has eaten all the ducks.
 Your task is to write a program which will read in the number of ducks N and the eating
interval M, then list the ducks and the time when each was eaten. N and M will appear on the
same input line and will be non-negative. This process must be repeated until an input value of
N = 0 is found.
 Note that the ducks must be numbered on the output list in the order they were originally
swimming. Separate the output from consecutive input data cases by two blank lines.

The input file name is ?k.in?.
*/


public class KProblem {

    private static int duckCount;
    private static int crocTimer;
    private static int[] ducks;
    private static int crocPos;

    public static void main(String[] args) throws FileNotFoundException {
        File theFile = new File("./k.in");
        Scanner scn = new Scanner(theFile);
        duckCount = scn.nextInt();
        crocTimer = scn.nextInt();
        while (duckCount != 0 && crocTimer != 0) {
            ducks = new int[duckCount];
            crocPos = 0;

            for (int i = 1; i <= duckCount; i++) {
                if (i % 2 == 1) {
                    clockwise(i);
                } else {
                    counterclock(i);
                }
            }

            for (int i = 0; i < ducks.length; i++) {
                System.out.println("Duck " + (i+1) + " eaten at time " + ducks[i]);
            }

            System.out.print("\n\n");

            duckCount = scn.nextInt();
            crocTimer = scn.nextInt();
        }
    }

    private static void clockwise(int i) {
        int counter = 0;
        boolean pacifism = true;

        while (pacifism) {
            if (ducks[crocPos] == 0) {
                counter++;

                if (counter == crocTimer) {
                    ducks[crocPos] = i;
                    return;
                }
            }

            crocPos++;
            if (crocPos == duckCount) {
                crocPos = 0;
            }

        }

    }

    private static void counterclock(int i) {
        int counter = 0;
        boolean pacifism = true;

        while (pacifism) {
            if (ducks[crocPos] == 0) {
                counter++;

                if (counter == crocTimer) {
                    ducks[crocPos] = i;
                    return;
                }
            }

            crocPos--;
            if (crocPos == -1) {
                crocPos = duckCount-1;
            }

        }
    }

}

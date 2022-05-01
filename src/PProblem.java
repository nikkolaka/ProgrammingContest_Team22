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




/*There is a rectangular room whose floor is covered with square tiles. The north and south walls are x
tiles in width, and the west and east walls are y tiles in length. A ball is launched from an airgun in
the northwest corner of the room. For convenience, you can think of this location having coordinates
(1,1). The airgun is aimed toward the southeast. The travel of the ball follows these rules:
? The ball always moves diagonally (northwest, northeast, southwest, or southeast).
? The ball?s direction has two components: a vertical component (north or south) and a
horizontal component (west or east). Thus, its initial southeast heading has a vertical
component of south and a horizontal component of east.
? If the ball hits the north wall, its vertical direction component changes to south.
? If the ball hits the south wall, its vertical direction component changes to north.
? If the ball hits the west wall, its horizontal direction component changes to east.
? If the ball hits the east wall, its horizontal direction component changes to west.
Ignoring any effects of gravity and assuming that the ball travels perfectly according to the above
rules, it will eventually return to its original launch location at (1,1). Below is an example of a 4x3
room, diagrammed into several steps, beginning with the first new location of the ball after its launch:

The input file name is ?p.in?.
*/





public class PProblem {

    public static void main(String[] args) throws FileNotFoundException {
        File theFile = new File("./p.in");
        Scanner scn = new Scanner(theFile);
        int h = scn.nextInt();
        int w = scn.nextInt();
        while (h != 0 && w != 0){
            int solution = bounce(h,w);
            System.out.println(solution);
            h = scn.nextInt();
            w = scn.nextInt();
        }
    }

    private static int bounce(int height, int width) {
        int vertDir = 1;
        int horDir = 1;
        int result = 0;
        boolean notDone = true;
        int currentX = 1;
        int currentY = 1;

        while (notDone) {
            if (currentY == height) {
                vertDir = -1;
            }
            if (currentY == 1) {
                vertDir = 1;
            }
            if (currentX == width) {
                horDir = -1;
            }
            if (currentX == 1) {
                horDir = 1;
            }

            currentX += horDir;
            currentY += vertDir;
            result++;

            if (currentX == 1 && currentY == 1) {
                notDone = false;
            }

            //move
        }

        return result;
    }

}

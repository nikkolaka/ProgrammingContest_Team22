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


/*
Write a program which prints out exactly N integers from among the input integers read
from a file named ?n.in?. N is the very first input (and N is not considered one of the
inputs to be printed.)
Print the first N values that are either less than -20 or greater than +200, but you are not
to print the values 217 or ?30 if they happen to appear in the input (those are the Barney?s
special numbers and are to be left alone).
Remember, your program must print exactly N numbers (otherwise Barney won?t think
you are special!). You may assume that there will be at least N printable values in the
input. Print values one per line.
*/



public class Nproblem {

    public static void main(String[] args) throws FileNotFoundException {
        File theFile = new File("./n.in");
        Scanner scn = new Scanner(theFile);
        int i = scn.nextInt();
        int printCount = 0;
        boolean stayHere = true;
        while (stayHere) {
            int thisNum = scn.nextInt();
            if (thisNum > 200 || thisNum < -20) {
                if (thisNum != 217 && thisNum != -30) {
                    System.out.println(thisNum);
                    printCount++;
                }
            }
            if (printCount == i) {
                stayHere = false;
            }
        }
    }

}

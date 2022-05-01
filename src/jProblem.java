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

/*Write a program which prints a figure that looks like the following figure. The first figure shown would
represent the output for an input of 11. That is, there are eleven rows. Each row is composed of the digit that
corresponds to the row, except that when we get past the one-digit numbers, we use an asterisk instead of the
digit. Each row contains exactly 2 * N digits or asterisks, where N corresponds to the row number, with row
numbers beginning with the highest number at the top -- in other words, there are 22 asterisks in the first row,
20 asterisks in the second, then 18 nines in the third row, etc. The figure must be centered for every row,
relative to the top (longest) row.
Write your program to accept multiple data sets from a file named ?j.in?. Each data set consists of one single
integer, which specifies the number of rows. Begin each output triangle with the input value, labeled as shown.
Follow the input value with a blank line. Each new triangle should be separated from the previous one by three
blank lines. NOTE: the bold and italicized statements in the output section are to clarify where blank lines go ?
they should not be printed as part of your output.
Continue processing until the program encounters a negative input ? that will be the sentinel (in other words,
that?s when you should quit.) No input value will ever be larger than 50.*/




public class jProblem {

    public static void main(String[] args) throws FileNotFoundException {
        File theFile = new File("./j.in");
        Scanner scn = new Scanner(theFile);
        int i = scn.nextInt();
        while (i >= 0){
            System.out.println("Input: " + i + "\n");
            printTriangle(i);
            i = scn.nextInt();
        }
    }

    private static void printTriangle(int n) {
        int indent = 0;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < indent; j++) {
                System.out.print(" ");
            }
            indent++;
            if (i > 9) {
                for (int j = 0; j < i; j++) {
                    System.out.print("**");
                }
            } else {
                for (int j = 0; j < i; j++) {
                    System.out.print(i + "" + i);
                }
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }

}

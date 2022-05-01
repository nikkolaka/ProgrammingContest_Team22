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


/*Rock, Paper, Scissors is a two player game, where each player simultaneously chooses one of the three items
after counting to three. The game typically lasts a pre-determined number of rounds. The player who wins the
most rounds wins the game. Given the number of rounds the players will compete, it is your job to determine
which player wins after those rounds have been played.

The input file name is ?q.in?.
*/



public class qProblem {


    public static void main(String[] args) throws FileNotFoundException {
        File theFile = new File("./q.in");
        Scanner scn = new Scanner(theFile);
        String tempLine = scn.nextLine();
        int games = Integer.parseInt(tempLine);
        //int games = scn.nextInt();
        while (games > 0) {
            String tempLine2 = scn.nextLine();
            int rounds = Integer.parseInt(tempLine2);
//            int rounds = scn.nextInt();
            int result = 0;
            while (rounds > 0) {
                String hands = scn.nextLine();
                if (hands.charAt(0) == 'R') {
                    if (hands.charAt(2) == 'R') {
                        //n
                    }
                    if (hands.charAt(2) == 'S') {
                        //rock beats scissors
                        result++;
                    }
                    if (hands.charAt(2) == 'P') {
                        // rock loses to paper
                        result--;
                    }
                }
                if (hands.charAt(0) == 'S') {
                    if (hands.charAt(2) == 'R') {
                        result--;
                    }
                    if (hands.charAt(2) == 'S') {


                    }
                    if (hands.charAt(2) == 'P') {

                        result++;
                    }
                }
                if (hands.charAt(0) == 'P') {
                    if (hands.charAt(2) == 'R') {
                        result++;
                    }
                    if (hands.charAt(2) == 'S') {

                        result--;
                    }
                    if (hands.charAt(2) == 'P') {

                    }
                }
                rounds--;
            }
            if (result >0){
                System.out.println("Player 1");
            }
            if (result < 0){
                System.out.println("Player 2");
            }
            if (result == 0){
                System.out.println("TIE");
            }
            games--;
        }
    }

}

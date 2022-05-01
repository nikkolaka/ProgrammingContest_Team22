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


/*Given a base, and two positive integers in decimal (base 10), convert the two numbers to the new
base, add them, and display their sum in the new base.
Input: Three positive integers denoting the base and the two numbers, respectively. Input numbers
will be integers between 0 and 65535. Bases will be between 2 and 10 inclusive. Each case will be
on a separate line. The end of input will be denoted by three zeros. Output: An equation for the sum
of the two numbers, in the new base


The input file name is ?l.in?.
*/


public class LProblem {
    public static void main(String[] args) throws FileNotFoundException {
        File theFile = new File("./l.in");
        Scanner scn = new Scanner(theFile);
        int base = scn.nextInt();
        int first = scn.nextInt();
        int second = scn.nextInt();
        while (base != 0){
            int result = first + second;
            System.out.println(convert(base,first) + " + " + convert(base,second) + " = " + convert(base,result));
            base = scn.nextInt();
            first = scn.nextInt();
            second = scn.nextInt();
        }
    }

    public static String convert(int base, int num){
        String str = "";
        int max = 0;
        int count = 0;
        int value = num;
        while(max < num){
            max = (int) Math.pow(base, count);
            count++;
        }
        for (int i = count; i >= 0; i--) {
            if(value >= Math.pow(base, i)){
                int temp = value/(int)Math.pow(base, i);
                value -= temp*Math.pow(base, i);
                str += temp;
            } else{
                str += "0";
            }
        }
        int s = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '0'){
                break;
            }
            s++;

        }
        return str.substring(s);
    }

}

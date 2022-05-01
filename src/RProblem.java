import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/* These problems were for the Puget Sound Spring Programming Contest
The competition was for High-school students up-to undergraduate seniors in teams of three.
It was run by Professor Tom Capaul and Professor Chris Marriot.

* Our team was Number 22 and on our team we had:
* James R Deal
* Luke McAlpine
* Nicholas Zhuk
*
* */





/*This problem calls for you to sort a list of words. But not so fast! Before you break out your favorite sorting algorithm and
start coding you might want to note that the strings aren?t to be sorted in alphabetical order, necessarily. They are to be
sorted according to an order dictated by the input file. For example, given the following three words:

apple banana bug bugs

And the following order of lowercase letters:

bcdaueflmnghopqijyzkrsxtvw

The output words should be ordered as follows:

banana bug bugs apple

The input file name is ?r.in?.
*/





public class RProblem {
    public static void main(String[] args) throws FileNotFoundException {
        File theFile = new File("./r.in");
        Scanner scn = new Scanner(theFile);

        String lineInput = scn.nextLine();
        while (!Objects.equals(lineInput, "#")) {

            String[] words = lineInput.split(" ");
            String alphabet = scn.nextLine();
            List<Word> theWords = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {
                theWords.add(new Word(words[i], alphabet));
            }

            Collections.sort(theWords);

            for (int i = 0; i < theWords.size(); i++) {
                System.out.print(theWords.get(i).w + " ");
            }

            System.out.print("\n");

            lineInput = scn.nextLine();
        }

    }

/*    private static boolean lessThan(String one, String two, String alphabet) {

        return false;
    }*/

    private static class Word implements Comparable<Word> {

        public String w;
        public String a;

        public Word(String s, String al) {
            w = s;
            a = al;
        }

        private int placement(char c) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == c) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int compareTo(Word o) {
            int result = 0;
            int i = 0;

            if (w.equals(o.w)) {
                return 0;
            }

            while (w.charAt(i) == o.w.charAt(i)) {
                i++;
                if (i == w.length() || i == o.w.length()) {
                    return w.length() - o.w.length();
                }
            }

            return this.placement(w.charAt(i)) - o.placement(o.w.charAt(i));
        }
    }
}

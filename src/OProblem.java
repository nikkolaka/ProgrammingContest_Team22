import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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


//NOT FINISHED IN TIME
/*Each customer arrives at Bimbo's Burgers and takes a number. The customer who arrived earliest (i.e. with
        lowest time) is served first. If two or more customers arrived at the same time, the one with the lower number is
        served first.
        Input (from file: o.in):
        Input will start with an integer giving the number of customers. This is followed by multiple lines, each
        describing one customer. Each line contains the customer's number, arrival time, service duration, and name
        separated by single spaces. Names consist only of letters (no spaces). There will be no more than 30 customers.
        No two customers will get the same number upon arriving at Bimbo's.
        Output:
        Print the time it takes between the time each customer arrives until they are done. The times should be listed in
        the order in which the customers leave Bimbo's, using the format shown in the example. */


public class OProblem {
    public static void main(String[] args) throws FileNotFoundException {
        File theFile = new File("./O.in");
        Scanner scn = new Scanner(theFile);
        int numCustomer = scn.nextInt();
        List<Customer> cust = new ArrayList<>();
        for (int i = 0; i < numCustomer; i++) {

            cust.add(new Customer(scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.next()));

        }
        Collections.sort(cust);
        int curTime = 0;
        for (int i = 0; i < cust.size(); i++) {
            System.out.println(cust.get(i).name+" took "+ cust.get(i).orderTime+curTime+" seconds.");
            curTime += cust.get(i).orderTime;
            if(i < cust.size() - 1) {
                curTime += cust.get(i+1).arrivalTime - cust.get(i).arrivalTime;

        }

        }
    }
    private static class Customer implements Comparable<Customer>{
        int ordernum;
        int arrivalTime;
        int orderTime;
        String name;
        public Customer (int ordernum, int arrivalTime, int orderTime, String name){
            this.ordernum = ordernum;
            this.arrivalTime = arrivalTime;
            this.orderTime = orderTime;
            this.name = name;
        }
        @Override
        public int compareTo(Customer o) {
            return this.ordernum-o.ordernum;
        }
    }
}

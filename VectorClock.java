
import java.util.*;

class VectorClock {
    static int n = 3;
    static int[][] clock = new int[n][n];

    static void internalEvent(int p) {
        clock[p][p]++;
        System.out.println("P" + (p+1) + " Internal Event: "
                + Arrays.toString(clock[p]));
    }

    static int[] sendMessage(int p) {
        clock[p][p]++;
        System.out.println("P" + (p+1) + " Sends Message: "
                + Arrays.toString(clock[p]));
        return clock[p].clone();
    }

    static void receiveMessage(int p, int[] msg) {
        for (int i = 0; i < n; i++)
            clock[p][i] = Math.max(clock[p][i], msg[i]);

        clock[p][p]++;

        System.out.println("P" + (p+1) + " Receives Message: "
                + Arrays.toString(clock[p]));
    }

    static void compare(int[] a, int[] b) {
        boolean less = false, greater = false;

        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) less = true;
            if (a[i] > b[i]) greater = true;
        }

        if (!less && !greater)
            System.out.println("Events are EQUAL");
        else if (less && !greater)
            System.out.println("Event A causally precedes Event B");
        else if (!less && greater)
            System.out.println("Event B causally precedes Event A");
        else
            System.out.println("Events are CONCURRENT");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] A, B;

        System.out.println("VECTOR CLOCK SIMULATOR");

        internalEvent(0);
        A = sendMessage(0);

        internalEvent(1);
        B = sendMessage(1);

        receiveMessage(2, A);
        internalEvent(2);

        receiveMessage(1, A);

        System.out.println("\nCompare Event Timestamps:");
        System.out.println("A = " + Arrays.toString(A));
        System.out.println("B = " + Arrays.toString(B));
        compare(A, B);

        System.out.println("\nFinal Vector Clocks:");
        for (int i = 0; i < n; i++)
            System.out.println("P" + (i+1) + " : "
                    + Arrays.toString(clock[i]));

        sc.close();
    }
}

import dsa.LinkedQueue;
import stdlib.StdOut;

public class Josephus {
    // Entry point.
    public static void main(String[] args) {
        if (args.length > 0) {
            // Accept n (int) and m (int) as command-line arguments.
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            // Create a queue q and enqueue integers 1, 2, ..., n.
            LinkedQueue<Integer> q = new LinkedQueue<Integer>();
            for (int i = 1; i <= n; i++) {
                q.enqueue(i);
            }

            // Set i to 0. As long as q is not empty: increment i; dequeue an element (say pos); ifm
            // divides i, write pos to standard output, otherwise enqueue pos to q.
            int i = 0;
            int pos = 0;
            while (!q.isEmpty()) {
                for (i = 1; i <= n; i++) {
                    pos = q.dequeue();
                    if (i % m == 0) {
                        StdOut.println(pos);
                        break;
                    }
                    q.enqueue(pos);
                }
            }
        }
    }
}

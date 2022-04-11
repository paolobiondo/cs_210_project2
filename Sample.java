import stdlib.StdOut;

public class Sample {
    // Entry point.
    public static void main(String[] args) {
        if (args.length > 0) {
            int lo = Integer.parseInt(args[0]); 
            int hi = Integer.parseInt(args[1]);
            int k = Integer.parseInt(args[2]);
            String mod = args[3];
            if (mod.equals("+") || mod.equals("-")) {
                ResizingArrayRandomQueue<Integer> q = new ResizingArrayRandomQueue<Integer>();
                for (int i = lo; i <= hi; i++) {
                    q.enqueue(i);
                }

                if (mod.equals("+")) {
                    for (int i = 0; i < k; i++) {
                        StdOut.println(q.sample());
                    }
                } else {
                    for (int i = 0; i < k; i++) {
                        StdOut.println(q.dequeue());
                    }
                }
            } else {
                throw new IllegalArgumentException("Illegal mode");
            }
        }
    }
}

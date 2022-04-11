import dsa.LinkedStack;

import stdlib.StdIn;
import stdlib.StdOut;

public class Sort {
    // Entry point.
    public static void main(String[] args) {
        // creation deques
        LinkedDeque<String> d = new LinkedDeque<String>();
        LinkedStack<String> s = new LinkedStack<String>();

        // add standard input inside d
        while (!StdIn.isEmpty()) {
            String w = StdIn.readString();
            if (d.isEmpty()) {
                d.addFirst(w);
            } else {
                // add w at the beginning of d if w is less than the first element in d
                if (less(w, d.peekFirst())) {
                    d.addFirst(w);
                // add w at the end of d if the last element is less than w
                } else if (less(d.peekLast(), w)) {
                    d.addLast(w);
                } else {
                    // remove w and put in a temp deque if the first element is less than w
                    while (true) {
                        if (less(d.peekFirst(), w)) {
                            String temp = d.removeFirst();
                            s.push(temp);
                        } else {
                            // add w to the beginning of the deque and
                            // move back all the words from temp deque to d
                            d.addFirst(w);
                            for (String item : s) {
                                String temp = s.pop();
                                d.addFirst(temp);
                            }
                            break;
                        }
                    }
                }
            }
        }
        for (String word : d) {
            StdOut.println(word);
        }
    }

    // Returns true if v is less than w according to their lexicographic order, and false otherwise.
    private static boolean less(String v, String w) {
        return v.compareTo(w) < 0;
    }
}

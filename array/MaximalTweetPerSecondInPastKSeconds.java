import java.util.Deque;
import java.util.LinkedList;

class MyClass {

    public static void tweets_per_second(Integer[] tps, Integer k) {
        // Write your code here
        // To print results to the standard output please use System.out.println
        // Example: System.out.println("Hello world!");

        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < tps.length; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && tps[i] >= tps[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
            System.out.println(tps[deque.peekFirst()]);
        }
    }
}

package queue;
// Not optimal solve it if forget

import java.util.LinkedList;
import java.util.Queue;

public class WinnerInCircularGame {
    // Better Solution
    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            // Move k-1 people to the end
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            // Remove the k-th person
            queue.poll();
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        int n = 456;
        int k = 1;
        System.out.println("Winner is player #" + findTheWinner(n, k));
    }
}

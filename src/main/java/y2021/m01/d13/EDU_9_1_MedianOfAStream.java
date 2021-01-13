package y2021.m01.d13;

import java.util.PriorityQueue;

// O(n) space
public class EDU_9_1_MedianOfAStream {
    PriorityQueue<Integer> bottomHalf = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> topHalf = new PriorityQueue<>((a, b) -> a - b);

    // O(log n) time
    public void insertNum(int num) {
        Integer minTop = bottomHalf.peek();
        if (minTop == null) {
            bottomHalf.offer(num);
            return;
        }
        if (num <= minTop) bottomHalf.offer(num);
        else topHalf.offer(num);

        // rebalance
        while (bottomHalf.size() > topHalf.size() + 1) {
            topHalf.offer(bottomHalf.poll());
        }
        while (topHalf.size() > bottomHalf.size()) {
            bottomHalf.offer(topHalf.poll());
        }
    }

    // O(1) time
    public double findMedian() {
        if (bottomHalf.size() == 0) return 0;
        if (bottomHalf.size() == topHalf.size()) {
            return ((double) bottomHalf.peek() + (double) topHalf.peek()) / 2;
        }
        return bottomHalf.peek();
    }
}

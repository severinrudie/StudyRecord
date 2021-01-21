package y2021.m01.d21;

import java.util.PriorityQueue;

// O(nk) time, O(k) space [adding to the heap is log(k), but removing from it is k]
public class EDU_9_2_FindSlidingWindowMedian {

    PriorityQueue<Integer> lowerHalf;
    PriorityQueue<Integer> upperHalf;

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        lowerHalf = new PriorityQueue<>((a,b) -> b - a);
        upperHalf = new PriorityQueue<>((a,b) -> a - b);

        double[] result = new double[nums.length - k + 1];

        int l = 0;
        int r = 0;

        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
            r++;
        }

        while (r <= nums.length) {
            result[l] = getMedian(k);

            if (r < nums.length) {
                removeNum(nums[l]);
                addNum(nums[r]);
            }

            l++;
            r++;
        }

        return result;
    }

    void addNum(int num) {
        if (lowerHalf.size() == 0) {
            lowerHalf.offer(num);
        } else if (upperHalf.size() == 0) {
            upperHalf.offer(num);
        } else if (num < upperHalf.peek()) {
            lowerHalf.offer(num);
        } else {
            upperHalf.offer(num);
        }
        rebalance();
    }

    void removeNum(int num) {
        if (!lowerHalf.remove(num)) {
            upperHalf.remove(num);
        }
        rebalance();
    }

    void rebalance() {
        while (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.offer(lowerHalf.poll());
        }
        while (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    double getMedian(int k) {
        if (k % 2 == 0) {
            return lowerHalf.peek() / 2.0 + upperHalf.peek() / 2.0;
        } else if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        } else {
            return upperHalf.peek();
        }
    }
}

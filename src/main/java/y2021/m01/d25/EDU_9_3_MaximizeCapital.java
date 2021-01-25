package y2021.m01.d25;

import java.util.PriorityQueue;

public class EDU_9_3_MaximizeCapital {
    // O(n log n + k log n) time, O(n) space
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int currCapital) {
        // [capital, profit]
        PriorityQueue<int[]> affordable = new PriorityQueue<>((a, b) -> b[1] - a[1]); // max queue, by profit
        PriorityQueue<int[]> unaffordable = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min queue, by capital

        for (int i = 0; i < capital.length; i++) {
            if (capital[i] <= currCapital) {
                affordable.offer(new int[] { capital[i], profits[i] });
            } else {
                unaffordable.offer(new int[] { capital[i], profits[i] });
            }
        }

        for (int i = 0; i < numberOfProjects; i++) {
            System.out.println("Adding: " + affordable.peek()[1]);
            currCapital += affordable.poll()[1];
            while (unaffordable.size() > 0 && unaffordable.peek()[0] <= currCapital) {
                affordable.offer(unaffordable.poll());
            }
        }

        return currCapital;
    }
}

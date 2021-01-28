package y2021.m01.d27;

import java.util.PriorityQueue;

public class EDU_9_C1_NextInterval {
    // O(n^2 log n) time, O(n) space
    // TODO redo.  Their answer is O(n log n) time, O(n) space using two heaps
    // (a simple comparison sort would be better here, but it's a learning xp)
    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];

        PriorityQueue<Item> lower = new PriorityQueue<>((a, b) -> b.start - a.start);
        PriorityQueue<Item> higher = new PriorityQueue<>((a,b) -> a.start - b.start);

        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            higher.offer(new Item(interval.start, i));
        }

        for (int i = 0; i < intervals.length; i++) {
            int nextEnd = intervals[i].end;
            while (lower.peek() != null && lower.peek().start > nextEnd) {
                higher.offer(lower.poll());
            }
            while (higher.peek() != null && higher.peek().start < nextEnd) {
                lower.offer(higher.poll());
            }
            Item nextHigher = higher.peek();
            if (nextHigher == null) {
                result[i] = -1;
            } else {
                result[i] = nextHigher.index;
            }
        }
        return result;
    }
}


class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Item {
    int start = 0;
    int index = 0;

    Item(int start, int index) {
        this.start = start;
        this.index = index;
    }
}



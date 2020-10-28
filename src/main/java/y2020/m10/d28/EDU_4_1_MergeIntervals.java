package y2020.m10.d28;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

// O(n log n) time, O(n) space
public class EDU_4_1_MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparing(interval -> interval.start));
        LinkedList<Interval> mergedIntervals = new LinkedList<Interval>();
        mergedIntervals.addLast(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Interval prev = mergedIntervals.getLast();
            if (prev.end > curr.start) {
                mergedIntervals.removeLast();
                mergedIntervals.addLast(new Interval(prev.start, Math.max(curr.end, prev.end)));
            } else {
                mergedIntervals.addLast(curr);
            }
        }

        return mergedIntervals;
    }
}

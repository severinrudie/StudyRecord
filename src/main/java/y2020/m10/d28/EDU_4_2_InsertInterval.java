package y2020.m10.d28;

import shared.Interval;

import java.util.ArrayList;
import java.util.List;

// O(n) time, O(n) space
public class EDU_4_2_InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        for (int i = 0; i <= intervals.size(); i++) {
            if (i == intervals.size()) {
                intervals.add(newInterval);
                break;
            }
            Interval curr = intervals.get(i);
            if (newInterval.start < curr.start) {
                intervals.add(i, newInterval);
                break;
            }
        }

        List<Interval> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = mergedIntervals.get(mergedIntervals.size() - 1);
            Interval curr = intervals.get(i);

            if (prev.end >= curr.start) {
                int start = Math.min(prev.start, curr.start);
                int end = Math.max(prev.end, curr.end);
                mergedIntervals.remove(mergedIntervals.size() - 1);
                mergedIntervals.add(new Interval(start, end));
            } else {
                mergedIntervals.add(curr);
            }
        }

        return mergedIntervals;
    }
}

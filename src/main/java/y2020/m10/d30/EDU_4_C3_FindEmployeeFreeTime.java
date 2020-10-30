package y2020.m10.d30;

import shared.Interval;

import java.util.ArrayList;
import java.util.List;

// EDU uses a min heap instead of manually merging lists.  Easier, and more efficient
// O(nk) time [n is the total number of intervals and k is the number of lists], O(n) space
public class EDU_4_C3_FindEmployeeFreeTime {
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> mergedLists = mergeKLists(schedule);
        List<Interval> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(mergedLists.get(0));

        for (int i = 1; i < mergedLists.size(); i++) {
            Interval last = mergedIntervals.get(mergedIntervals.size() - 1);
            Interval next = mergedLists.get(i);
            if (next.start <= last.end) {
                int newStart = Math.min(last.start, next.start);
                int newEnd = Math.max(last.end, next.end);
                mergedIntervals.remove(mergedIntervals.size() - 1);
                mergedIntervals.add(new Interval(newStart, newEnd));
            } else {
                mergedIntervals.add(next);
            }
        }

        List<Interval> result = new ArrayList<>();
        for (int i = 1; i < mergedIntervals.size(); i++) {
            result.add(new Interval(
                            mergedIntervals.get(i - 1).end,
                    mergedIntervals.get(i).start
            ));
        }

        return result;
    }

    static List<Interval> mergeKLists(List<List<Interval>> lists) {
        List<Interval> allMerged = new ArrayList<>();
        while (lists.size() != 0) {
            List<Interval> one = lists.remove(0);
            List<Interval> two;
            if (lists.size() == 0) {
                two = null;
            } else {
                two = lists.remove(0);
            }

            List<Interval> merged;
            if (one == null && two == null) {
                break;
            } if (one != null && two != null) {
                merged = mergeTwoLists(one, two);
            } else if (one != null) {
                merged = one;
            } else {
                merged = two;
            }

            allMerged = mergeTwoLists(merged, allMerged);
        }
        return allMerged;
    }

    static List<Interval> mergeTwoLists(List<Interval> one, List<Interval> two) {
        List<Interval> merged = new ArrayList<>();
        while (one.size() > 0 && two.size() > 0) {
            if (one.get(0).start <= two.get(0).start) {
                merged.add(one.remove(0));
            } else {
                merged.add(two.remove(0));
            }
        }
        while (one.size() > 0) {
            merged.add(one.remove(0));
        }
        while (two.size() > 0) {
            merged.add(two.remove(0));
        }
        return merged;
    }
}

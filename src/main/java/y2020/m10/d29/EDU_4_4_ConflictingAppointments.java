package y2020.m10.d29;

import shared.Interval;

import java.util.Arrays;
import java.util.Comparator;

// O(n log n) time, O(1) space
public class EDU_4_4_ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) return false;
        }

        return true;
    }
}

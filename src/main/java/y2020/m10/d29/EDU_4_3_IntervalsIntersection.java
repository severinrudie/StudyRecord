package y2020.m10.d29;

import shared.Interval;

import java.util.ArrayList;
import java.util.List;

public class EDU_4_3_IntervalsIntersection {

    static Interval[] a1;
    static Interval[] a2;
    static List<Interval> intersections;
    static int one;
    static int two;

    // O(nk) time, O(nk) space
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        intersections = new ArrayList<>();
        a1 = arr1;
        a2 = arr2;
        one = 0;
        two = 0;

        if (a1.length == 0 || a2.length == 0) return intersections.toArray(new Interval[0]);;

        while (one < a1.length && two < a2.length) {
            maybeAdd();
            if (one == a1.length -1 && two == a2.length - 1) {
                break;
            } else if (one == a1.length - 1) {
                two++;
            } else if (two == a2.length - 1) {
                one++;
            } else if (a1[one].end == a2[two].end) {
                if (a1[one + 1].start <= a2[two + 1].start) {
                    one++;
                } else {
                    two++;
                }
            } else if (a1[one].end <= a2[two].end) {
                one++;
            } else {
                two++;
            }
        }
        return intersections.toArray(new Interval[intersections.size()]);
    }

    static void maybeAdd() {
        if (doIntersect(a1[one], a2[two])) {
            intersections.add(getIntersection(a1[one], a2[two]));
        }
    }

    static boolean doIntersect(Interval i1, Interval i2) {
        if (i1.start >= i2.start && i1.start <= i2.end) {
            return true;
        } else if (i2.start >= i1.start && i2.start <= i1.end) {
            return true;
        } else if (i1.end <= i2.end && i1.end >= i2.start) {
            return true;
        } else if (i2.end <= i1.end && i2.end >= i1.start) {
            return true;
        } else {
            return false;
        }
    }

    static Interval getIntersection(Interval i1, Interval i2) {
        return new Interval(Math.max(i1.start, i2.start), Math.min(i1.end, i2.end));
    }


}

package y2020.m10.d30;

import shared.Meeting;

import java.util.HashMap;
import java.util.List;

// EDU has an O(n log n) time, O(n) space solution.  I don't understand why it's O(n log n), talk to Briceida
// O(k) time [where k == the total hours when meetings are held], O(k) space
public class EDU_4_C1_MinimumMeetingRooms {
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        HashMap<Integer, Integer> roomCount = new HashMap<>();

        for (Meeting meeting : meetings) {
            for (int i = meeting.start; i <= meeting.end; i++) {
                roomCount.put(i, roomCount.getOrDefault(i, 0) + 1);
            }
        }

        int maxRooms = 0;
        for (int count : roomCount.values()) {
            maxRooms = Math.max(maxRooms, count);
        }

        return maxRooms;
    }
}

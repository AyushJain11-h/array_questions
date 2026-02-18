import java.util.*;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min-heap to track end times
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!heap.isEmpty() && heap.peek() <= interval[0]) {
                heap.poll(); // Room is free
            }
            heap.offer(interval[1]); // Add current meeting
        }

        return heap.size(); // Number of rooms needed
    }
}


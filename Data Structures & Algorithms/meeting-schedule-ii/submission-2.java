/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        List<int[]> points = new ArrayList<>();
        for (Interval i: intervals) {
            points.add(new int[]{i.start, -1});
            points.add(new int[]{i.end, 1});
        }

        Collections.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);


        int res = 0;
        int room = 0;
        int prev = -1;
        for (int[] p: points) {
            if (p[1] == -1) {
                room++;
            } else if (p[1] == 1) {
                room--;
            }

            res = Math.max(res, room);
        }

        return res;
    }
}

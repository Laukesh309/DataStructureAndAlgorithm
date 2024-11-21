package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class MeetingTime implements Comparable<MeetingTime> {
    int start;
    int end;

    MeetingTime(int start, int end) {
        this.start = start;
        this.end = end;

    }

    @Override
    public int compareTo(MeetingTime m2) {
        return this.end - m2.end;
    }
}

public class NMeetingProblem {

    public static void printArray(MeetingTime mt[]) {
        for (MeetingTime item : mt) {
            System.out.print(item.end + " ");
        }
    }

    public static int maximumMeeting(MeetingTime mt[]) {
        int prevEnd = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < mt.length; i++) {
            if (mt[i].start > prevEnd) {
                result++;
                prevEnd = mt[i].end;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        MeetingTime mt[] = new MeetingTime[start.length];
        for (int i = 0; i < mt.length; i++) {
            mt[i] = new MeetingTime(start[i], end[i]);
        }
        Arrays.sort(mt);
        // printArray(mt);
        maximumMeeting(mt);
    }

}

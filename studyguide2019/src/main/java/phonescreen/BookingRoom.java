package phonescreen;

import java.util.List;

public class BookingRoom {

    public int minimumRooms(List<InterviewSchedule> schedules) {
        if (schedules == null || schedules.isEmpty()) {
            return -1;
        }

        int maxRange = 0;
        for (int i = 0; i < schedules.size(); ++i) {
            maxRange = Math.max(maxRange, schedules.get(i).endHour);
        }

        int[] bookings = new int[maxRange + 1];

        for (InterviewSchedule sch : schedules) {
            int start = sch.startHour;
            for (int i = start; i < sch.endHour; ++i) {
                bookings[i] += 1;
            }
        }

        int maxNumberOfRooms = 0;
        for (int i = 0; i < bookings.length; ++i) {
            maxNumberOfRooms = Math.max(maxNumberOfRooms, bookings[i]);
        }
        return maxNumberOfRooms;
    }

    public static class InterviewSchedule {
        public int startHour;
        public int endHour;

        public InterviewSchedule(int start, int end) {
            startHour = start;
            endHour = end;
        }
    }
}

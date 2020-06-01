package phonescreen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import phonescreen.BookingRoom.InterviewSchedule;

import java.util.ArrayList;
import java.util.List;

public class BookingRoomTest {

    @Test
    public void test1() {
        List<InterviewSchedule> schedules = new ArrayList<>();
        schedules.add(new InterviewSchedule(1,3));
        schedules.add(new InterviewSchedule(2,4));
        schedules.add(new InterviewSchedule(4,5));

        BookingRoom room = new BookingRoom();
        int result = room.minimumRooms(schedules);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void test2() {
        List<InterviewSchedule> schedules = new ArrayList<>();
        BookingRoom room = new BookingRoom();
        int result = room.minimumRooms(schedules);
        Assertions.assertEquals(-1, result);
    }
}

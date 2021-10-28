package hash;

import java.time.Instant;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyMapTimeTest {

  @Test
  public void testAddToMapOneValue() {
    IMapTime<Integer, Date, String> mapTime = new MyMapTime<>();
    Date time = Date.from(Instant.now());
    mapTime.put(1, time, "Rodrigo");
    Assertions.assertFalse(mapTime.isEmpty());
    Assertions.assertEquals("Rodrigo", mapTime.get(1, time));
  }

  @Test
  public void testAddToMapTwoValuesDifferentTimes() {
    IMapTime<Integer, Date, String> mapTime = new MyMapTime<>();
    Date time = Date.from(Instant.now());
    mapTime.put(1, time, "Rodrigo");

    Date time2 = Date.from(Instant.ofEpochMilli(3000));
    mapTime.put(1, time2, "Vanessa");

    Assertions.assertFalse(mapTime.isEmpty());
    Assertions.assertEquals("Rodrigo", mapTime.get(1, time));
    Assertions.assertEquals("Vanessa", mapTime.get(1, time2));
  }

  @Test
  public void testAddToMapSameTimeDifferentKeyValue() {
    IMapTime<Integer, Date, String> mapTime = new MyMapTime<>();
    Date time = Date.from(Instant.now());
    mapTime.put(1, time, "Rodrigo");
    mapTime.put(2, time, "Vanessa");

    Assertions.assertFalse(mapTime.isEmpty());
    Assertions.assertEquals("Rodrigo", mapTime.get(1, time));
    Assertions.assertEquals("Vanessa", mapTime.get(2, time));
  }

  @Test
  public void testAddToMapSameKeyDifferentTimeValue() {
    IMapTime<Integer, Date, String> mapTime = new MyMapTime<>();
    Date time = Date.from(Instant.now());
    mapTime.put(1, time, "Rodrigo");

    Date time2 = Date.from(Instant.ofEpochMilli(3000));
    mapTime.put(1, time2, "RodrigoF");

    Assertions.assertFalse(mapTime.isEmpty());
    Assertions.assertEquals("Rodrigo", mapTime.get(1, time));
    Assertions.assertEquals("RodrigoF", mapTime.get(1, time2));
  }
}

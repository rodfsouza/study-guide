package hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayMapTest {

  @Test
  public void testPutIntegerToString() {
    IMap<Integer, String> myMap = new ArrayMap<>();
    myMap.put(1, "Rodrigo");
    myMap.put(2, "Ben");
    myMap.put(3, "Vani");
    Assertions.assertFalse(myMap.isEmpty());
  }

  @Test
  public void testPutDuplicatedKeys() {
    IMap<Integer, String> myMap = new ArrayMap<>();
    myMap.put(1, "RodrigoF");
    Assertions.assertThrows(IllegalArgumentException.class, () -> myMap.put(1, "RodrigoSouza"));
  }

  @Test
  public void testPutCollisionKeys() {
    IMap<Integer, String> myMap = new ArrayMap<>();
    myMap.put(1, "RodrigoF");
    myMap.put(23, "RodrigoSouza");
    myMap.put(34, "VanessaSouza");
    Assertions.assertFalse(myMap.isEmpty());
  }

  @Test
  public void testPutCollisionKeysAndGets() {
    IMap<Integer, String> myMap = new ArrayMap<>();
    myMap.put(1, "RodrigoF");
    myMap.put(23, "RodrigoSouza");
    myMap.put(34, "VanessaSouza");

    String first = myMap.get(1);
    String sec = myMap.get(23);
    String third = myMap.get(34);

    Assertions.assertEquals("RodrigoF", first);
    Assertions.assertEquals("RodrigoSouza", sec);
    Assertions.assertEquals("VanessaSouza", third);
  }

  @Test
  public void testGetNullKey() {
    IMap<Integer, String> myMap = new ArrayMap<>();
    Assertions.assertNull(myMap.get(1));
    Assertions.assertFalse(myMap.isEmpty());
  }
}

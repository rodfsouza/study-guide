package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import recursion.BiggestListCycle.Node;

public class BiggestListCycleTest {

    @Test
    public void test1() {
        Node head = new Node();
        head.data = 2;
        Node n2 = new Node();
        n2.data = 4;
        head.next = n2;
        n2.parent = head;
        Node n3 = new Node();
        n3.data = 6;
        n3.parent = n2;
        n2.next = n3;
        Node n4 = new Node();
        n4.data = 14;
        n4.parent = n3;
        n3.next = n4;
        Node n5 = new Node();
        n5.data = 5;
        n5.parent = n4;
        n4.next = n5;
        Node n6 = new Node();
        n6.data = 10;
        n6.parent = n5;
        n5.next = n6;
        Node n7 = new Node();
        n7.data = 9;
        n7.parent = n6;
        n6.next = n7;

        Node down1 = new Node();
        down1.data = 3;
        n6.down = down1;
        down1.down = n7;

        Node down2 = new Node();
        down2.data = 1;
        n2.down = down2;
        n3.down = down2;
        Node down3 = new Node();
        down3.data = 3;
        down2.down = down3;
        Node down4 = new Node();
        down4.data = 5;
        down3.down = down4;
        down4.down = n5;

        BiggestListCycle b = new BiggestListCycle();
        int result = b.largestCycle(head);
        Assertions.assertEquals(8, result);
    }
}

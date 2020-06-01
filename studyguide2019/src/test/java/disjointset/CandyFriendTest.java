package disjointset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CandyFriendTest {

    @Test
    public void testCandyFriendsHappyCase1() {
        List<Integer> friends_from = Arrays.asList(1, 1, 2, 2, 2);
        List<Integer> friends_to = Arrays.asList(2, 2, 3, 3, 4);
        List<Integer> friends_weight = Arrays.asList(1, 2, 1, 3, 3);
        int friends_nodes = 4;

        int maxProduct = CandyFriends.countCandies(friends_nodes, friends_from, friends_to, friends_weight);
        Assertions.assertEquals(12, maxProduct);
    }

    @Test
    public void testCandyFriendsHappyCase2() {
        List<Integer> friends_from = Arrays.asList(1, 1, 2);
        List<Integer> friends_to = Arrays.asList(3, 3, 3);
        List<Integer> friends_weight = Arrays.asList(1, 2, 2);
        int friends_nodes = 3;

        int maxProduct = CandyFriends.countCandies(friends_nodes, friends_from, friends_to, friends_weight);
        Assertions.assertEquals(6, maxProduct);
    }

    @Test
    public void testCandyFriendsHappyCase3() {
        List<Integer> friends_from = Arrays.asList(1, 2, 3, 4, 1, 2, 3);
        List<Integer> friends_to = Arrays.asList(5, 5, 5, 5, 2, 3, 4);
        List<Integer> friends_weight = Arrays.asList(1, 1, 1, 1, 2, 2, 2);
        int friends_nodes = 7;

        int maxProduct = CandyFriends.countCandies(friends_nodes, friends_from, friends_to, friends_weight);
        Assertions.assertEquals(20, maxProduct);
    }
}

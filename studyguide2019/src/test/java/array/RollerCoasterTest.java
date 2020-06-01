package array;

import org.junit.jupiter.api.Test;

public class RollerCoasterTest {

    @Test
    public void testRollerCoasterSimple() {

        int[] line = {2,1,5,3,4};
        RollerCoaster rl = new RollerCoaster();
        rl.minimumBribes(line);
    }

    @Test
    public void testRollerCoasterTooChaotic2() {

        int[] line = {2, 5, 1, 3, 4};
        RollerCoaster rl = new RollerCoaster();
        rl.minimumBribes(line);
    }


    @Test
    public void testRollerCoasterSimple3() {

        int[] line = {1, 2, 5, 3, 4, 7, 8, 6};
        RollerCoaster rl = new RollerCoaster();
        rl.minimumBribes(line);
    }

    @Test
    public void testRollerCoasterTooChaotic() {

        int[] line = {5, 1, 2, 3, 7, 8, 6, 4};
        RollerCoaster rl = new RollerCoaster();
        rl.minimumBribes(line);
    }
}

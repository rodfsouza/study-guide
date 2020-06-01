package stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class BuildingHeight {

    public int id;
    public int height;

    public BuildingHeight(int id, int height) {
        this.id = id;
        this.height = height;
    }

    public Deque<BuildingHeight> checkIfHasSunset(Iterator<Integer> sequence) {
        if (sequence == null) {
            return new LinkedList<>();
        }

        int buildingId = 0;
        Deque<BuildingHeight> buildingsWithSunset = new LinkedList<>();

        while (sequence.hasNext()) {
            int buildingHeight = sequence.next();

            while (!buildingsWithSunset.isEmpty() && buildingHeight >= buildingsWithSunset.getLast().height) {
                buildingsWithSunset.removeLast();
            }

            buildingsWithSunset.addLast(new BuildingHeight(buildingId++, buildingHeight));
        }
        return buildingsWithSunset;
    }


}

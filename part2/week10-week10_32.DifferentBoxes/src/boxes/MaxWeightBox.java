package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {
    private List<Thing> things;
    private int maxWeight;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }
    
    public int getWeight() {
        int sum = 0;
        for(Thing thing : things) {
            sum += thing.getWeight();
        }
        return sum;
    }

    @Override
    public void add(Thing thing) {
        if(thing.getWeight() + getWeight() <= maxWeight) {
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return things.contains(thing);
    }
}

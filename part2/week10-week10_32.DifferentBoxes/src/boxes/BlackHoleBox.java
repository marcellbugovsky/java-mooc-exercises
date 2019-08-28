package boxes;

import java.util.ArrayList;
import java.util.List;

public class BlackHoleBox extends Box {
    private List<Thing> things;
    
    public BlackHoleBox() {
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
        this.things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
}

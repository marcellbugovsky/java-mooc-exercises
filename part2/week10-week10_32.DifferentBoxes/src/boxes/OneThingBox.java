package boxes;

import java.util.ArrayList;
import java.util.List;

public class OneThingBox extends Box {
    private List<Thing> thing;
    
    public OneThingBox() {
        this.thing = new ArrayList<Thing>();
    }
    
    public int getWeight() {
        return thing.get(0).getWeight();
    }

    @Override
    public void add(Thing thing) {
        if(this.thing.isEmpty()) {
            this.thing.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.thing.contains(thing);
    }
}

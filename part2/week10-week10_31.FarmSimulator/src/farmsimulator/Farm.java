package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private List<Cow> cows;
    
    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }
    
    public void addCow(Cow cow) {
        cows.add(cow);
    }
    
    public void manageCows() {
        barn.takeCareOf(cows);
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }
    
    public String getOwner() {
        return this.owner;
    }

    @Override
    public void liveHour() {
        for(Cow cow : cows) {
            cow.liveHour();
        }
    }
    
    @Override
    public String toString() {
        String str = "Farm owner: " + this.owner + "\n";
        str += "Barn bulk tank: " + barn.getBulkTank() + "\n";
        if(!cows.isEmpty()) {
            str += "Animals:\n";
            for(Cow cow : cows) {
                str += "        " + cow + "\n";
            }
        }else{
            str += "No cows.";
        }
        return str;
    }
}

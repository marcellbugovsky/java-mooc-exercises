package farmsimulator;

import java.util.Collection;

public class Barn {
    private BulkTank tank;
    private MilkingRobot milkingRobot;
    
    public Barn(BulkTank tank) {
        this.tank = tank;
    }
    
    public BulkTank getBulkTank() {
        return this.tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkingRobot = milkingRobot;
        milkingRobot.setBulkTank(tank);
    }
    
    public void takeCareOf(Cow cow) {
        try{
            milkingRobot.milk(cow);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        try{
            for(Cow cow : cows){
                milkingRobot.milk(cow);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    @Override
    public String toString() {
        return "Barn: " + tank.getVolume() + "/" + tank.getCapacity();
    }
}

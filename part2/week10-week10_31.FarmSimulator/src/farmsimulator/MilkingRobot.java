package farmsimulator;


public class MilkingRobot {
    private BulkTank tank;
    
    public MilkingRobot() {
        
    }
    
    public BulkTank getBulkTank() {
        return this.tank;
    }
    
    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }
    
    public void milk(Milkable milkable) {
        if(tank != null){
            tank.addToTank(milkable.milk());
        }else{
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
    }
}

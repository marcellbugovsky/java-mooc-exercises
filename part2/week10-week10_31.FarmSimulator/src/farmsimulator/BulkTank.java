package farmsimulator;

public class BulkTank {
    private double capacity;
    private double volume;
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }
    
    public BulkTank() {
        this(2000);
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    public double getVolume() {
        return this.volume;
    }
    
    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }
    
    public void addToTank(double amount) {
        if(this.volume + amount <= this.capacity) {
            this.volume += amount;
        }else{
            this.volume = this.capacity;
        }
    }
    
    public double getFromTank(double amount) {
        if(this.volume >= amount) {
            this.volume -= amount;
            return amount;
        }else{
            amount = this.volume;
            this.volume = 0;
            return amount;
        }
    }
    
    @Override
    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}

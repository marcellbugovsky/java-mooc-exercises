package farmsimulator;

import java.util.Random;

public class Cow implements Alive, Milkable{
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    private String name;
    private double capacity;
    private double amount;
    private Random random;
    
    public Cow(String name) {
        this.random = new Random();
        this.name = name;
        this.capacity = 15 + random.nextInt(25);
        this.amount = 0;
    }
    
    public Cow() {
        this(NAMES[new Random().nextInt(30)]);
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.amount) + "/" + Math.ceil(this.capacity);
    }

    @Override
    public void liveHour() {
        double amountProduced;
        amountProduced = (10 + random.nextInt(10)) / 10;
        if(this.amount + amountProduced <= this.capacity) {
            this.amount += amountProduced;
        }else{
            this.amount = this.capacity;
        }
    }

    @Override
    public double milk() {
        double amountTaken = this.amount;
        this.amount = 0;
        return amountTaken;
    }
}

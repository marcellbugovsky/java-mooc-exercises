package farmsimulator;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        
        Cow cow = new Cow();
        System.out.println(cow);


        Alive livingCow = cow;
        livingCow.liveHour();

        System.out.println(cow);
        livingCow.liveHour();

        System.out.println(cow);

        Milkable milkingCow = cow;
        milkingCow.milk();

        System.out.println(cow);
        System.out.println("");

        cow = new Cow("Ammu");
        System.out.println(cow);
        cow.liveHour();
        cow.liveHour();
        System.out.println(cow);
        cow.milk();
        System.out.println(cow);
    }
}

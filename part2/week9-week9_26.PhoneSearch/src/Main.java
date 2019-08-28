import java.util.Scanner;
import phoneBook.*;

public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        UI ui = new UI(new Scanner(System.in));
        ui.start();
    }
}

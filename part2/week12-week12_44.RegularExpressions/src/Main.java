
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Give a string: ");
        String str = reader.nextLine();
        
        if(clockTime(str)) {
            System.out.println("The form is fine.");
        }else{
            System.out.println("The form is wrong.");
        }
    }
    
    public static boolean isAWeekDay(String string) {
        if(string.matches("(mon|tue|wed|thu|fri|sat|sun)")) {
            return true;
        }else {
            return false;
        }
    }
    
    public static boolean allVowels(String string) {
        if(string.matches("[aeiouyüöä]+")) {
            return true;
        }else {
            return false;
        }
    }
    
    public static boolean clockTime(String string) {
        if(string.matches("(([0-1][0-9])|2[0-3]):[0-5][0-9]:[0-5][0-9]")) {
            return true;
        }else {
            return false;
        }
    }
}

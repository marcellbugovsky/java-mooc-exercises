package personnel;

public class Main {

    public static void main(String[] args) {
        Employees t = new Employees(); 
Person h = new Person("Artso", Education.D); 
t.add(h); 
t.fire(Education.D); 
t.print();
    }
}

public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n ");
        int j = 1;
        for(int i = 0; i < t.length; i++) {
            builder.append(t[i]);
            if(i != t.length - 1) {
                builder.append(", ");
            }
            if(j == 4 && i != t.length - 1) {
                builder.append("\n ");
                j = 1;
            }else{
                j++;
            }
        }
        builder.append("\n}");
        
        return builder.toString();
    }
}

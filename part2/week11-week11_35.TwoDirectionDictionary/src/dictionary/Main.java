package dictionary;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MindfulDictionary s = new MindfulDictionary("test/tmp/tmp32194.txt");
        s.load();
        System.out.println(s.translate("test"));
        s.add("tietokone", "computer");
        s.add("tietokon1e", "comput1er");
        s.save();
    }
}

package lab3;

import java.util.ArrayList;

public class BaseParser {
    private ArrayList<String> arrayOfParts;

    BaseParser(String str) {
        arrayOfParts = new ArrayList<>();
        String[] part1 = str.split(",");
        for(int i = 0; i < part1.length; i++) {
            arrayOfParts.add(part1[i].replaceAll("\"", ""));
        }
    }
    String getString(int index) {
        return arrayOfParts.get(index);
    }
}

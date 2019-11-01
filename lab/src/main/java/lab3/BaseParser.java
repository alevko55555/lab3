package lab3;

import java.util.ArrayList;

public class BaseParser {
    private ArrayList<String> part;

    BaseParser(String str) {
        part = new ArrayList<>();
        String[] part1 = str.split(",");
        for(int i = 0; i < part1.length; i++) {
            part.add(part1[i].replaceAll("\"", ""));
        }
    }
    String getString(int index) {
        return part.get(index);
    }
}

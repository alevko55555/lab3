package lab2;

import java.util.ArrayList;

public class ParserUtils {
    private ArrayList<String> part;

    ParserUtils(String str) {
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

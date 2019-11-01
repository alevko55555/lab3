package lab3;

import java.util.ArrayList;

public class BaseParser {
    private static final String ZERO_DOUBLE = "0.0";
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
    Long getLong(int index) {
        String str = arrayOfParts.get(index);
        String num = str.isEmpty() ? ZERO_DOUBLE : str;
        return (long)Double.parseDouble(num);
    }
}

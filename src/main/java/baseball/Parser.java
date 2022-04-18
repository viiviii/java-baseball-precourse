package baseball;

import java.util.ArrayList;
import java.util.List;

public final class Parser {

    public static List<Integer> asIntegerList(String str) {
        final String[] chars = str.trim().split("");
        final List<Integer> integers = new ArrayList<>();
        for (String s : chars) {
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }
}

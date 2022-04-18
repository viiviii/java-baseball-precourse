package baseball;

import baseball.model.GameNumbers;

import java.util.ArrayList;
import java.util.List;

public final class Parser {

    // TODO: static.....?
    public static GameNumbers asGameNumbers(String str) {
        List<Integer> integers;
        try {
            integers = asIntegerList(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return GameNumbers.fromIntegers(integers);
    }

    public static List<Integer> asIntegerList(String str) {
        final String[] chars = str.trim().split("");
        final List<Integer> integers = new ArrayList<>();
        for (String s : chars) {
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }
}

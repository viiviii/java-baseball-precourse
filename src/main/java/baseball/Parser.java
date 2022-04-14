package baseball;

import java.util.ArrayList;
import java.util.List;

// TODO: 클래스명...
public final class Parser {

    // TODO: static.....?
    public static List<Integer> parseIntegerList(String input) {
        try {
            return parse(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> parse(String input) {
        final String[] chars = input.trim().split("");
        final List<Integer> result = new ArrayList<>();
        for (String s : chars) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}

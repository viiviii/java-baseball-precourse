package baseball;

import camp.nextstep.edu.missionutils.Console;

public final class SystemSomeOther implements SomeOther {

    @Override
    public Object input() {
        return Console.readLine();
    }
}

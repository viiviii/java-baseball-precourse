package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

// TODO: immutable 해야하나? 사람은 그대로니까 mutable 한가?
// TODO: 검증 완료 된 gameNumbers와 검증 안된 List<Integer> 중 무얼 갖고 있어야할까? -> 누가 유효성 검증?
public class AIHost extends Host {

    @Override
    protected GameNumbers setGameNumbers() {
        return new GameNumbers(pickRandomUniqueNumbers());
    }

    private List<Integer> pickRandomUniqueNumbers() {
        final int start = 1; // TODO
        final int end = 9;
        final int count = 3;
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}

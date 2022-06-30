package baseball.gameStrategy;

import baseball.gamePlay.Score;

class MatchRecorder {
    private int strike;
    private int ball;

    void increase(Match match) {
        if (match.isStrike()) {
            strike += 1;
        }
        if (match.isBall()) {
            ball += 1;
        }
    }

    Score toScore() {
        return new Score(strike, ball);
    }
}

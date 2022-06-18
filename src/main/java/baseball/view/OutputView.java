package baseball.view;

import baseball.Score;
import java.util.List;

public interface OutputView {

    void selectNumberRequest();

    void selectNumberResponse(List<Score> scores);
}
